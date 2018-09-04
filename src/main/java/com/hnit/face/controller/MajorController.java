package com.hnit.face.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Class;
import com.hnit.face.bean.Course;
import com.hnit.face.bean.Curricula;
import com.hnit.face.bean.Major;
import com.hnit.face.service.ClassService;
import com.hnit.face.service.CourseService;
import com.hnit.face.service.CurriculaService;
import com.hnit.face.service.MajorService;
import com.hnit.face.service.TeacherService;

@Controller
@RequestMapping("/major")
public class MajorController {

	@Autowired
	MajorService service;
	
	@Autowired
	TeacherService teaService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CurriculaService curriculaService;
	
	@Autowired
	ClassService classService;
	
	@ResponseBody
	@RequestMapping("getMajorList")
	public List<Major> getMajorsByDeptId(HttpServletRequest request,String deptId) {
		
		System.out.println("deptId : "+deptId);
		
		List<Major> list = service.getMajorListByDeptId(deptId); 	
		System.out.println(list);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("getClassList")
	public List<com.hnit.face.bean.Class> getClassList(String teacherId){
		
		Course course = courseService.getCourseList(teacherId); 		// 得到的是Course表
																		// 通过 Course.id 关联 Curricula 得到班级 id
		List<Curricula> curriculaList = curriculaService.getCurriculaList(course.getId());
		
		System.out.println(curriculaList); 				
		
		List<Integer> classIdList = new ArrayList<>();		// 将所有的 classId 存到里面
		
		for(Curricula c:curriculaList) { 			// 将 Curricla 表中的 id 取出来 
			classIdList.add(c.getClassId()); 				
		}
		
		List<Class> classList = getClassByIdList(classIdList);
		
		return classList;
		
	}
	
	public List<com.hnit.face.bean.Class> getClassByIdList(List<Integer> idList){
		
		List<com.hnit.face.bean.Class> classList = new ArrayList<>();
		 
		
		for(Integer id:idList) {
			classList.add( classService.getClassById(id)); 
		}
		
		return classList;
	}
	
}
