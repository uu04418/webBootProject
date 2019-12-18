package com.bootproject.sklweb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.common.HandleData;
import com.bootproject.sklweb.common.PageQuery;
import com.bootproject.sklweb.entity.User;
import com.bootproject.sklweb.entity.UserExample;
import com.bootproject.sklweb.mapper.MyCustomerMapper;
import com.bootproject.sklweb.mapper.UserMapper;
import com.bootproject.sklweb.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserMapper userMapper;
	
	@Autowired
	MyCustomerMapper myCustomerMapper;
	@Override
	public APIResponse addOrUpdateUser(User user) {
		
		if (CheckDataUtil.checkisEmpty(user)
				|| CheckDataUtil.checkisEmpty(user.getUserid()))
			return APIResponse.build(900, "请输入登陆账户") ;
		
		String acctoken = HandleData.getNewToken() ;
		
		User searchUser = userMapper.selectByPrimaryKey(user.getUserid());
		
		String password = HandleData.digestMD5Word(user.getPassword()) ;
		
		// 这里是编辑用户
		if (CheckDataUtil.checkNotEmpty(password)) {
			user.setPassword(password);
		}
		user.setAcctoken(acctoken);
		
		
		if (CheckDataUtil.checkNotEmpty(searchUser)) {
			userMapper.updateByPrimaryKeySelective(user) ;
		} else {
			
			if (CheckDataUtil.checkisEmpty(user.getPassword()))
				return APIResponse.build(900, "请输入登陆密码");
			user.setCreatetime(new Date());
			userMapper.insertSelective(user);
		}
		
		
		return APIResponse.build(200, "添加成功");
	}

	public User getUserByToken(String acctoken) {
		
		
		if (CheckDataUtil.checkisEmpty(acctoken))
			return null; 
		
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andAcctokenEqualTo(acctoken);
		List<User> users = userMapper.selectByExample(example);
		if (CheckDataUtil.checkisEmpty(users))
			return null; 
		return users.get(0);
	}

	@Override
	public int getUserListCount() {
		// TODO Auto-generated method stub
		return myCustomerMapper.getUserListCount();
	}

	@Override
	public List<User> getUserList(PageQuery query) {
		// TODO Auto-generated method stub
		return myCustomerMapper.getUserList(query);
	}

	public APIResponse userLogin(String userid, String password) {
		
		if(CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(password)) {
			return APIResponse.build(400, "请输入登陆账户或者密码");
		} 
		
		User user = userMapper.selectByPrimaryKey(userid);
		
		if (CheckDataUtil.checkisEmpty(user)) {
			return APIResponse.build(400, "改用户不存在") ;
		}
		
		if (CheckDataUtil.checkNotEqual("0", user.getType())
				&& CheckDataUtil.checkNotEqual("1", user.getType()))
			return APIResponse.build(400, "非后台账户") ;
		
		if(CheckDataUtil.checkNotEqual("0", user.getState()))
			return APIResponse.build(400, "用户冻结或移除") ;
		
		password = HandleData.digestMD5Word(password);
		
		if (CheckDataUtil.checkNotEqual(password, user.getPassword()))
			return APIResponse.build(400, "密码错误") ;
		
		return APIResponse.offResult(user);
	}

}
