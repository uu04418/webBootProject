package com.bootproject.sklweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.service.ProductService;
import com.bootproject.sklweb.service.UserService;

@Controller
@ResponseBody
@RequestMapping("/product")
public class ProductControler {
	
	@Autowired 
	ProductService productService; 
	
	@Autowired 
	UserService userService;
	
	@RequestMapping("/list")
	
	public APIResponse getItem() {
		
		productService.getItem();
		userService.getUserByToken("131312") ;
		return APIResponse.offResult();
	}

}
