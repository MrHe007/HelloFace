package com.hnit.face.to;

import java.util.HashMap;
import java.util.Map;

public class MsgTo {
	
	private String code;
	private String msg;
	private String state; 		// 保留位
	private Map<String,String> data = new HashMap<>();
	
	public MsgTo() {
		this.code = "405"; 		// 表示出错 
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ErrorTo [code=" + code + ", msg=" + msg + ", state=" + state + ", data=" + data + "]";
	}
	public MsgTo(String code, String msg, String state, Map<String, String> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.state = state;
		this.data = data;
	}

	
	
	
}
