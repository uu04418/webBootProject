package com.bootproject.sklweb.service;

import java.util.List;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.PageQuery;
import com.bootproject.sklweb.entity.User;

public interface UserService {
	
	/**
	**@Desctription 新增后台用户或者删除后台用户
	**@author  uu04418
	**@date  2019年12月18日  上午11:20:31
	**@param user
	**@return		
	*
	 */
	APIResponse addOrUpdateUser(User user);
	
	/**
	**@Desctription 通过用户 acctoken 获取用户信息
	**@author  uu04418
	**@date  2019年12月18日  上午11:42:07
	**@param acctoken
	**@return		
	*
	 */
	User getUserByToken(String acctoken);
	
	/**
	**@Desctription 获取用户列表
	**@author  uu04418
	**@date  2019年12月18日  下午2:24:08
	**@return		
	*
	 */
	int getUserListCount();
	List<User> getUserList(PageQuery query);
	
	/**
	**@Desctription 用户登陆
	**@author  uu04418
	**@date  2019年12月18日  下午2:53:22
	**@param userid
	**@param password
	**@return		
	*
	 */
	APIResponse userLogin(String userid, String password);

	APIResponse changepass(String userid, String password);

}
