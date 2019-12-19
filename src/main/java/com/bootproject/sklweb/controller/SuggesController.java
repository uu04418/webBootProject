package com.bootproject.sklweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.entity.Sugges;
import com.bootproject.sklweb.service.SuggesService;

@Controller
@ResponseBody
@RequestMapping("/sugges")
public class SuggesController {
	
	@Autowired
	SuggesService suggesService;
	
	
	@RequestMapping("/addsugges")
	public APIResponse addSugges (Sugges sugges) {
		return suggesService.addSugges(sugges) ;
	}
	
	

}
