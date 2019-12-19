package com.bootproject.sklweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.service.CategoryService;
import com.bootproject.sklweb.service.UserService;

@Controller
@ResponseBody
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	UserService userService ;
	
	@Autowired
	CategoryService categoryService; 
	
	@RequestMapping("/userlogin")
	public APIResponse userLogin (String userid , String password) {
		
		return userService.userLogin(userid , password ) ;
		
	}
	
	@RequestMapping("/getallcategory")
	public APIResponse getallcategory ( 
			String state ){
		
		return categoryService.getallcategory(state) ;
	}
	
}
