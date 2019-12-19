package com.bootproject.sklweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.entity.Scene;
import com.bootproject.sklweb.entity.SceneExample;
import com.bootproject.sklweb.mapper.MyCustomerMapper;
import com.bootproject.sklweb.mapper.SceneMapper;
import com.bootproject.sklweb.service.SceneService;

@Service
public class ScenceServiceImpl implements SceneService{
	
	@Autowired
	SceneMapper sceneMapper;
	
	@Autowired
	MyCustomerMapper myCustomerMapper;

	@Override
	public APIResponse addOrUpdateScene(Scene scene) {
		
		if (CheckDataUtil.checkisEmpty(scene.getName()))
			return APIResponse.build(400, "请输入场合名");
		
		// 判断是否有重复的
		SceneExample example = new SceneExample() ;
		SceneExample.Criteria criteria  = example.createCriteria();
		criteria.andNameEqualTo(scene.getName()) ;
		
		List<Scene> list = sceneMapper.selectByExample(example);
		
		if (CheckDataUtil.checkNotEmpty(list))
			return APIResponse.build(400, "勿重复添加") ;
		
		if (CheckDataUtil.checkNotEmpty(scene.getId())) {
			sceneMapper.updateByPrimaryKeySelective(scene);
		} else {
			Integer id = myCustomerMapper.getLastSceneId();
			if (id < 10000)
				id = 10000;
			scene.setId(id);
			sceneMapper.insertSelective(scene);
		}
		
		return APIResponse.build(200, "操作成功");
	}

	@Override
	public APIResponse deleteScene(Integer id) {
		
		if (CheckDataUtil.checkisEmpty(id))
			return APIResponse.build(400, "选择场合");
		
		sceneMapper.deleteByPrimaryKey(id) ;
		
		return APIResponse.offResult();
	}

	@Override
	public APIResponse scenelist() {
		List<Scene> list = sceneMapper.selectByExample(null);
		return APIResponse.offResult(list);
	}

}
