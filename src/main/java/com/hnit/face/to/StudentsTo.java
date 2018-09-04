package com.hnit.face.to;

import java.util.ArrayList;
import java.util.List;

import com.hnit.face.bean.Student;

public class StudentsTo {

	private String code;
	private String msg;
	private Integer count;
	private List<Student> data = new ArrayList<>();
	
	
	
	
	public StudentsTo() {
		this.code = "0";
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Student> getData() {
		return data;
	}
	public void setData(List<Student> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "StudentsTo [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
	
}
