package com.bootproject.sklweb.filter;

@SuppressWarnings("serial")
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
