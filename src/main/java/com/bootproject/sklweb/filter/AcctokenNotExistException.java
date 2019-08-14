package com.bootproject.sklweb.filter;

@SuppressWarnings("serial")
public class AcctokenNotExistException extends RuntimeException {

    public AcctokenNotExistException() {
        super("请求需要token");
    }
}
