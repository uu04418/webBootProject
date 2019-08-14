package com.bootproject.sklweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootproject.sklweb.entity.User;
import com.bootproject.sklweb.service.UserService;


/**
 * @Description 用户controller
 * @author  uu04418
 * @date  2019年8月5日  上午9:21:17
 */
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@ResponseBody
	@RequestMapping("/getUser")
	public User getByUserId () {
		return userService.getByUserId();
	}
	

}
