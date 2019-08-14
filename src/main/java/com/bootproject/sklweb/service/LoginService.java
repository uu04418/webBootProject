package com.bootproject.sklweb.service;

import com.bootproject.sklweb.entity.Employee;

public interface LoginService {

	Employee getEmpById(int i);
	
	void inserEmployee (Employee employee);

}
