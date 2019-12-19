package com.bootproject.sklweb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.entity.Sugges;
import com.bootproject.sklweb.mapper.MyCustomerMapper;
import com.bootproject.sklweb.mapper.SuggesMapper;
import com.bootproject.sklweb.service.SuggesService;


@Service
public class SuggesServiceImpl implements SuggesService{

	@Autowired
	SuggesMapper suggesMapper;
	
	@Autowired
	MyCustomerMapper myCustomerMapper;
	
	@Override
	public APIResponse addSugges(Sugges sugges) {
		if (CheckDataUtil.checkisEmpty(sugges.getContent()))
			return APIResponse.build(400,"请输入内容") ;
		sugges.setCreatetime(new Date());
		suggesMapper.insertSelective(sugges);
		return APIResponse.offResult();
	}

	@Override
	public Integer suggeslistCount() {
		// TODO Auto-generated method stub
		return myCustomerMapper.suggeslistCount();
	}

	@Override
	public List<Sugges> suggeslist() {
		// TODO Auto-generated method stub
		return myCustomerMapper.suggeslist();
	}

}
