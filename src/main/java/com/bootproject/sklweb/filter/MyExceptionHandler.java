package com.bootproject.sklweb.filter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String UserNotExistException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",701);
        return "forward:/error";
    }
    
    @ExceptionHandler(AcctokenNotExistException.class)
    public String AcctokenNotExistException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",700);
        return "forward:/error";
    }
    
    @ExceptionHandler(UserFrozenException.class)
    public String UserFrozenException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",703);
        return "forward:/error";
    }
    
    @ExceptionHandler(SupporterNotAllowException.class)
    public String SupporterNotAllowException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",704);
        return "forward:/error";
    }
    
    @ExceptionHandler(AdminUserAllowException.class)
    public String AdminUserAllowException(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",706);
        return "forward:/error";
    }
}
