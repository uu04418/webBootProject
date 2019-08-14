package com.bootproject.sklweb.filter;

@SuppressWarnings("serial")
public class SupporterNotAllowException extends RuntimeException {

    public SupporterNotAllowException() {
        super("非后台成员用户");
    }
}
