package com.bootproject.sklweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bootproject.sklweb.common.PageQuery;
import com.bootproject.sklweb.entity.User;

public interface MyCustomerMapper {
	
	/**
	**@Desctription 查询用户列表
	**@author  uu04418
	**@date  2019年12月18日  下午2:26:35
	**@param query
	**@return		
	 */
	List<User> getUserList(@Param("query") PageQuery query);
	int getUserListCount();
}