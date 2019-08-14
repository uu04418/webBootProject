package com.bootproject.sklweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootproject.sklweb.entity.Employee;
import com.bootproject.sklweb.mapper.EmployeeMapper;
import com.bootproject.sklweb.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	EmployeeMapper employeeMapper;
	@Override
	public Employee getEmpById(int i) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmpById(i);
	}
	@Override
	public void inserEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertEmployee(employee);
	}

}
