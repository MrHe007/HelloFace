package com.hnit.face.to;

import java.util.List;

public class MsgDataTo {
	public String code;
	private String msg;
	private Integer count;
	private Object data;
	
	public MsgDataTo() {
		this.code = "0";
		this.msg = "";
		count = 0;
	}
	
	

	
	public Integer getCount() {
		return count;
	}




	public void setCount(Integer count) {
		this.count = count;
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "MsgDataTo [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	

}
