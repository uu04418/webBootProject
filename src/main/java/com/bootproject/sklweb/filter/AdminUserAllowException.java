package com.bootproject.sklweb.filter;

@SuppressWarnings("serial")
public class AdminUserAllowException extends RuntimeException {

    public AdminUserAllowException() {
        super("该操作只有管理员才可以操作");
    }
}
