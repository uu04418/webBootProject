package com.bootproject.sklweb.service;

import com.bootproject.sklweb.entity.User;

public interface UserService {

	User getByUserId();
	
	/**
	**@Desctription 通过acctoken获取用户信息
	**@author  uu04418
	**@date  2019年8月5日  上午9:45:19
	**@param acctoken
	**@return		
	*
	 */
	User getUserByAccToken(String acctoken);

}
