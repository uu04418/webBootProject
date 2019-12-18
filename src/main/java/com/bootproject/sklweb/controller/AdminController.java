package com.bootproject.sklweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.PageQuery;
import com.bootproject.sklweb.entity.User;
import com.bootproject.sklweb.service.UserService;

/**
 * @Description 管理员操作
 * @author  uu04418
 * @date  2019年12月18日  上午10:42:32
 */

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired UserService  userService;
	
	@RequestMapping("/addOrUpdateUser")
	public APIResponse addOrUpdateUser (User user) {
		return userService.addOrUpdateUser(user) ;
	}
	
	@RequestMapping("/userlist")
	public APIResponse searchUserList ( 
		@RequestParam(defaultValue="1")	int currentpage ,
		@RequestParam(defaultValue="8")	int pagesize) {
		int infoCount = userService.getUserListCount() ;
		PageQuery query = new PageQuery() ;
		query.setPageParams(infoCount, pagesize, currentpage);
		List<User> users = userService.getUserList(query) ;
		return APIResponse.offResult(users , query.getTotalpage());
	}
	
	
	
	
	

}
