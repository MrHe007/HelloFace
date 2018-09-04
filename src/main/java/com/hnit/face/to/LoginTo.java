package com.hnit.face.to;

import java.util.HashMap;
import java.util.Map;

public class LoginTo {
	
	private String code; 	// 响应状态码， 200：ok , 405 : 错误
	
	private String msg; 	// 消息
	
	private Map<String,String> data = new HashMap<>();

	public LoginTo() {
		this.code = "405"; 	// 默认是错误
		this.msg = "";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public LoginTo(String code, String msg, Map<String, String> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "LoginTo [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
	
}
