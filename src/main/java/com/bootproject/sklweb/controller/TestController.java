package com.bootproject.sklweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.entity.Employee;
import com.bootproject.sklweb.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(TestController.class);

	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/test")
	public APIResponse testConString () {
		
		Employee employee = loginService.getEmpById(77);
		logger.info("这是查到的数据=====" +  employee.toString());
		
		return APIResponse.offResult(employee);
		
	}
	
	@RequestMapping("/insertEmployee")
	public APIResponse insertEmployee (Employee employee) {
		
		loginService.inserEmployee(employee);
		
		return APIResponse.offResult();
		
	}
}
