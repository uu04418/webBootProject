package com.bootproject.sklweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.common.HandleData;
import com.bootproject.sklweb.common.PageQuery;
import com.bootproject.sklweb.entity.Category;
import com.bootproject.sklweb.entity.Product;
import com.bootproject.sklweb.entity.Scene;
import com.bootproject.sklweb.entity.Sugges;
import com.bootproject.sklweb.entity.User;
import com.bootproject.sklweb.service.CategoryService;
import com.bootproject.sklweb.service.ProductService;
import com.bootproject.sklweb.service.SceneService;
import com.bootproject.sklweb.service.SuggesService;
import com.bootproject.sklweb.service.UserService;

/**
 * @Description 后台数据操作
 * @author  uu04418
 * @date  2019年12月18日  上午10:43:03
 */

@Controller
@ResponseBody
@RequestMapping("/supporter")
public class SupporterControler {
	
	
	@Autowired
	SceneService sceneService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SuggesService suggesService; 
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	ProductService  productService; 
	
	@RequestMapping("/addOrUpdateProduct")
	public APIResponse addOrUpdateProduct ( HttpServletRequest request, Product product){
		String  acctoken = (String) request.getHeader("Authorization");
		User user = userService.getUserByToken(acctoken);
		product.setUserid(user.getUserid());
		
		return productService.addOrUpdateProduct(product) ;
	}
	
	
	@RequestMapping("/changepass")
	public APIResponse changepass( HttpServletRequest request,
			String password , String oldpassword  ) {
		String  acctoken = (String) request.getHeader("Authorization");
		
		User user = userService.getUserByToken(acctoken);
		if (CheckDataUtil.checkisEmpty(user))
			return APIResponse.build(400,"用户不存在") ;
		
		oldpassword = HandleData.digestMD5Word(oldpassword) ;
		
		if (CheckDataUtil.checkNotEqual(oldpassword, user.getPassword())) {
			return APIResponse.build(400, "原始密码错误") ;
		}
		 
		return userService.changepass( user.getUserid() ,  password );
	}
	
	@RequestMapping("/suggeslist")
	public APIResponse suggeslist (@RequestParam(defaultValue="1")Integer currentpage ,
			@RequestParam(defaultValue="8")Integer pagesize) {
		Integer infoCount = suggesService.suggeslistCount();
		PageQuery query = new PageQuery() ;
		query.setPageParams(infoCount, pagesize, currentpage);
		List<Sugges> list = suggesService.suggeslist();
		
		return APIResponse.offResult(list, query.getTotalpage());
	}
	
	
	@RequestMapping("/addOrUpdateScene")
	public APIResponse addOrUpdateScene(Scene scene) {
		return sceneService.addOrUpdateScene(scene) ;
	}
	
	
	
	@RequestMapping("/deleteScene")
	public APIResponse deleteScene(Integer id ) {
		return sceneService.deleteScene (id) ;
	}
	
	
	
	@RequestMapping("/scenelist")
	public APIResponse scenelist () {
		return sceneService.scenelist() ;
	}
	
	
	@RequestMapping("/addOrUpdateCategory")
	public APIResponse addOrUpdateCategory (Category category) {
		return categoryService.addOrUpdateCategory(category) ;
	}
	
	
	
	
}
