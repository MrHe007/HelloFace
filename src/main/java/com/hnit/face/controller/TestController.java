package com.hnit.face.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Student;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("demo1")
	@ResponseBody
	public Student demo1(HttpServletRequest request,String name,String age) {
		
		Student user = new Student();
		user.setName("hc");
		System.out.println(name);
		System.out.println(age);
		
		System.out.println("demo1");
		
		return user;
	}
}
