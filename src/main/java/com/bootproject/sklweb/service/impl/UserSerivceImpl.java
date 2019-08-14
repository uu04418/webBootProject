package com.bootproject.sklweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.entity.User;
import com.bootproject.sklweb.entity.UserExample;
import com.bootproject.sklweb.mapper.UserMapper;
import com.bootproject.sklweb.service.UserService;

@Service
public class UserSerivceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getByUserId() {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(1l);
	}

	/**
	**@Desctription 通过acctoken获取用户信息
	**@author  uu04418
	**@date  2019年8月5日  上午9:45:19
	**@param acctoken
	**@return		
	*
	 */
	public User getUserByAccToken(String acctoken) {
		UserExample example  =  new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andAcctokenEqualTo(acctoken);
		List<User> selectByExample = userMapper.selectByExample(example);
		if (CheckDataUtil.checkisEmpty(selectByExample))
		return null;
		return selectByExample.get(0);
	}

}
