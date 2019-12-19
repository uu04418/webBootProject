package com.bootproject.sklweb.service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.entity.Scene;

public interface SceneService {
	
	/**
	**@Desctription 添加编辑场景
	**@author  uu04418
	**@date  2019年12月18日  下午3:16:58
	**@param scene
	**@return		
	*
	 */
	APIResponse addOrUpdateScene(Scene scene);
	
	/**
	**@Desctription 删除场合
	**@author  uu04418
	**@date  2019年12月18日  下午3:30:33
	**@param id
	**@return		
	 */
	APIResponse deleteScene(Integer id);

	APIResponse scenelist();

}
