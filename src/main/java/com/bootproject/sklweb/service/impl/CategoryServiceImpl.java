package com.bootproject.sklweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.entity.Category;
import com.bootproject.sklweb.entity.CategoryExample;
import com.bootproject.sklweb.mapper.CategoryMapper;
import com.bootproject.sklweb.mapper.MyCustomerMapper;
import com.bootproject.sklweb.myentity.CategoryCustomer;
import com.bootproject.sklweb.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	MyCustomerMapper myCustomerMapper;
	
	@Override
	public APIResponse addOrUpdateCategory(Category category) {
		
		if (CheckDataUtil.checkisEmpty(category.getName()))
			return APIResponse.build(400, "请输入类别名称") ;
		
		if (CheckDataUtil.checkisEmpty(category.getFatherid()))  
			category.setFatherid("0");
		
		// 判断父节点是否存在
		boolean fatherNotExit = checkFatherState(category) ;
				
		if (fatherNotExit) 
			return APIResponse.build(400, "父节点不存在") ;
		
		// 判断是否有重复的
		CategoryExample example = new CategoryExample();
		CategoryExample.Criteria criteria = example.createCriteria();
		
		criteria.andFatheridEqualTo(category.getFatherid());
		criteria.andNameEqualTo(category.getName()) ;
		
		List<Category> list = categoryMapper.selectByExample(example);
		
		if (CheckDataUtil.checkNotEmpty(list)) 
			return APIResponse.build(400, "请勿重复添加") ;
		
		if (CheckDataUtil.checkNotEmpty(category.getId())) {
			categoryMapper.updateByPrimaryKeySelective(category);
		} else {
			//获取类别Id 方便查询
			String id = getCategoryId(category);
			category.setId(id);
			categoryMapper.insertSelective(category) ;
		}
 		
		return APIResponse.offResult();
	}
	
	/**
	**@Desctription 校验父节点不存在 不存在返回 true
	**@author  uu04418
	**@date  2019年12月18日  下午4:45:28
	**@param category
	**@return		
	*
	 */
	private boolean checkFatherState(Category category) {
		if (CheckDataUtil.checkNotEqual("0", category.getFatherid())) {
			Category father = categoryMapper.selectByPrimaryKey(category.getFatherid());
			if (CheckDataUtil.checkNotEmpty(father)) {
				return false  ;
			} else {
				return true  ;
			}
		}
		return false;
	}

	private String getCategoryId(Category category) {
		Integer id = myCustomerMapper.getCategoryIdByFahter(category.getFatherid());
		if (CheckDataUtil.checkisEmpty(id)) {
			// 如果是添加父节点
			if (CheckDataUtil.checkisEqual("0", category.getFatherid())) {
				return "1000";
			} else {
				return category.getFatherid() +  "1000" ;
			}
		}
		return id.toString();
	}

	@Override
	public APIResponse getallcategory(String state) {
		
		CategoryExample example = new CategoryExample();
		CategoryExample.Criteria criteria = example.createCriteria();
		if (CheckDataUtil.checkNotEmpty(state)) {
			criteria.andStateEqualTo(state) ;
		}
		
		
		List<Category> list = categoryMapper.selectByExample(example);
		
		List<CategoryCustomer> resultlist = new ArrayList<CategoryCustomer>();
		
		for (Category category : list) {
			if ( CheckDataUtil.checkisEqual("0", category.getFatherid()) ) {
				CategoryCustomer add = new CategoryCustomer() ;
				add.setContent(category.getContent());
				add.setFatherid(category.getFatherid());
				add.setId(category.getId());
				add.setName(category.getName());
				add.setState(category.getState());
				add.setPictures(category.getPictures());
				resultlist.add(add);
			}
		}
		
		
		for (CategoryCustomer customer : resultlist) {
			List<Category> sonlist = new ArrayList<>();
			for (Category category : list) {
				if (CheckDataUtil.checkisEqual(category.getFatherid(), customer.getId())) {
					sonlist.add(category) ;
				}
			}
			customer.setSonlist(sonlist);
		}
		
		
		return APIResponse.offResult(resultlist);
	}

}
