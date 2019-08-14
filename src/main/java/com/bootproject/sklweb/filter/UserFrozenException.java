package com.bootproject.sklweb.filter;

@SuppressWarnings("serial")
public class UserFrozenException extends RuntimeException {

    public UserFrozenException() {
        super("账号冻结");
    }
}
