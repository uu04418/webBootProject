package com.bootproject.sklweb.common;

import java.io.Serializable;

/**
 * @Description 通用数据返回结果集
 * @author  uu04418
 * @date  2019年8月1日  下午6:29:53
 */
public class APIResponse implements Serializable {

	private static final long serialVersionUID = -7434603105681424078L;

	// 响应业务状态
	private Integer code;

	// 响应消息
	private String message;

	// 响应中的数据
	private Object object;

	public static APIResponse build(Integer code, String message, Object object) {
		return new APIResponse(code, message, object);
	}

	public static APIResponse offResult(Object object) {
		return new APIResponse(object);
	}

	public static APIResponse offResult() {
		return new APIResponse(null);
	}

	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static APIResponse build(Integer code, String message) {
		return new APIResponse(code, message, null);
	}

	public APIResponse(Integer code, String message, Object object) {
		this.code = code;
		this.message = message;
		this.object = object;
	}

	public APIResponse(Object obj) {
		this.code = 200;
		this.message = "OK";
		this.object = obj;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}


	
	
}
