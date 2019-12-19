package com.bootproject.sklweb.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.entity.Product;
import com.bootproject.sklweb.mapper.MyCustomerMapper;
import com.bootproject.sklweb.mapper.ProductMapper;
import com.bootproject.sklweb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	MyCustomerMapper myCustomerMapper;
	
	@Override
	public void getItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public APIResponse addOrUpdateProduct(Product product) {
		
		if (CheckDataUtil.checkisEmpty(product.getCategoryid()))
			return APIResponse.build(400, "产品类别id必填");
		
		if(CheckDataUtil.checkisEmpty(product.getSceneid()))
			return APIResponse.build(400, "产品场合必填") ;
		
		if (CheckDataUtil.checkisEmpty(product.getName()))
			return APIResponse.build(400, "产品名称必填") ;
		
		if (CheckDataUtil.checkisEmpty(product.getId())) {
			Long id = myCustomerMapper.getNextProductId() ;
			product.setCreatetime(new Date());
			product.setId(id);
			product.setUpdatetime(new Date());
			productMapper.insertSelective(product) ;
		} else {
			product.setUpdatetime(new Date());
			productMapper.updateByPrimaryKeySelective(product);
		}
		
		return APIResponse.offResult();
		
		
		
	}

}
