package com.hnit.face.to;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendeceTo {
	
	private String code;
	private String msg;
	private Integer count;
	private List<StudentRegTo> data = new ArrayList<>();
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<StudentRegTo> getData() {
		return data;
	}
	public void setData(List<StudentRegTo> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "StudentAttendeceTo [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	public StudentAttendeceTo(String code, String msg, Integer count, List<StudentRegTo> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	
	public StudentAttendeceTo() {
		
		this.code = "0";
		this.msg = "";
		
	}
	

}
