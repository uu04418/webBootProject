package com.bootproject.sklweb.filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.entity.User;
import com.bootproject.sklweb.service.UserService;
import com.bootproject.sklweb.service.impl.UserServiceImpl;


/**
 * @Description  本系统通用拦截器
 * @author  uu04418
 * @date  2019年8月5日  上午9:34:31
 */
public class CommonInterceptor implements HandlerInterceptor {
	
	@Autowired
	UserService userService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/***
		 * 需要拦截的URL 必须包含    belogin【前台需要登陆操作】 
				              supporter【需要验证后台账号】 
				              admin 【需要验证管理员权限】
		**/
		String currentUrl = request.getRequestURI();
		String  acctoken = (String)request.getHeader("Authorization");
		if (   currentUrl.contains("supporter")
				|| currentUrl.contains("admin")) {
			//acctoken不能为空
			if (CheckDataUtil.checkisEmpty(acctoken))  
				throw new  AcctokenNotExistException() ;
			
			User user = userService.getUserByToken(acctoken) ;
			
			
			//通过acctoen获取用户信息 用户信息必须存在
			if (CheckDataUtil.checkisEmpty(user))  
				throw new  UserNotExistException() ;
			
			//账号被冻结
			if ( CheckDataUtil.checkNotEqual("0", user.getState()))  
				throw new  UserFrozenException() ;
			
			//如果带有管理员
			if(currentUrl.contains("admin") || currentUrl.contains("supporter")) {
				//非后台账户
				if (CheckDataUtil.checkNotEqual("1", user.getType())
						&&  CheckDataUtil.checkNotEqual("0", user.getType()))   
					throw new  SupporterNotAllowException() ;
				//需要管理员权限
				if (currentUrl.contains("admin") 
						&&  CheckDataUtil.checkNotEqual("0", user.getType()) ) 
					throw new  AdminUserAllowException() ;
			}
			
			return true ;
			
		}
		return true ;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
