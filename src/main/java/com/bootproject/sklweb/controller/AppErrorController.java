package com.bootproject.sklweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bootproject.sklweb.common.APIResponse;

/**
 * @Description 通用异常处理类
 * @author  uu04418
 * @date  2019年8月1日  下午6:39:25
 */
@Controller
public class AppErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }


    /**
    **@Desctription WEB页面跳转 。不作考虑所有页面前台跳转
    **@author  uu04418
    **@date  2019年8月5日  上午10:01:04
    **@param request
    **@param response
    **@return		
    *
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        return "redirect:errorpage.html?errorCode=" + status  ;
    }

    
    /**
    **@Desctription json 请求错误处理
    **@author  uu04418
    **@date  2019年8月5日  上午10:01:45
    **@param request
    **@return		
    *
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public APIResponse errorApiHandler(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);

        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        int status = getStatus(request);
        String valueDefault = String.valueOf(attr.getOrDefault("message", "error"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", status );
        map.put("errorMessage", valueDefault );
        Map<Integer, Object> codeError = new HashMap<>();
        codeError.put(400, "推送的数据类型不正确") ;
        codeError.put(500, "传入数据丢失空值等服务器端异常") ;
        codeError.put(404, "请求连接不存在") ;
        codeError.put(405, "服务器端指定了请求方式 PUT - GET - DELETE - POST ") ;
        codeError.put(503, "服务器不可用") ;
        codeError.put(700, "该操作token不能为空") ;
        codeError.put(701, "token获取的用户信息为 null") ;
        codeError.put(702, "前台操作需要用户登陆") ;
        codeError.put(703, "账号被冻结") ;
        codeError.put(704, "非后台账号无法操作后台") ;
        codeError.put(705, "用户名和密码不匹配") ;
        codeError.put(706, "需要管理员权限") ;
        map.put("常用CODE说明", codeError );
        return APIResponse.build(status, valueDefault, map);
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }

        return 500;
    }
}
