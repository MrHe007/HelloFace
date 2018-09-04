package com.hnit.face.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Class;
import com.hnit.face.bean.Student;
import com.hnit.face.service.ClassService;

@Controller
@RequestMapping("/class")
public class ClassController {

	@Autowired
	ClassService service;
	
	@RequestMapping("getClassListByMajorId")
	@ResponseBody
	public List<Class>  getClassListByMajorId(HttpServletRequest request,String majorId) {
		
		System.out.println("major = "+majorId);
		
		List<Class> classList = service.getClassListByMajorId(Integer.parseInt(majorId));
		
		System.out.println(classList);
		
		return classList;
	}
	
	
	
}
