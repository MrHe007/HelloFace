package com.hnit.face.utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import com.hnit.face.bean.Student;
import com.hnit.face.to.StudentsTo;

public class CommonUtils {
	
	
	public static StudentsTo convertStudentToStudentsTo(List<Student> students){
		
		StudentsTo to = new StudentsTo();
		
		to.setMsg("");
		to.setData(students);
		to.setCode("0");
		return to;
	}
	
	public static String strFromIsoToUtf(String source) {
		try {
			return new String(source.getBytes("iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("字符串转化失败!");
			e.printStackTrace();
		}
		return source;
	}
	
	
	
	
	
	
	
	
	
	public static String getYearId() {
		Calendar date = Calendar.getInstance();
		return date.get(date.YEAR)%100+"";
	}
	
	public static void main(String []args) {
		
		System.out.println(getYearId());
		
	}
	
	public static boolean isBlank(String str) { // 或者是全部是空格,用正则表达式解决
		
		return str.equals("") || str==null;
	}
	

}
