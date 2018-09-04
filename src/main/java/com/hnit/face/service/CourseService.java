package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Course;
import com.hnit.face.bean.CourseExample;
import com.hnit.face.bean.CourseExample.Criteria;
import com.hnit.face.dao.CourseMapper;

@Service
public class CourseService {
	
	@Autowired
	CourseMapper mapper;
	
	public Course getCourseList(String teacherId) {
		
		
		CourseExample ex = new CourseExample();
		Criteria c = ex.createCriteria();
		c.andTeacherIdEqualTo(Integer.parseInt(teacherId));
		
		List<Course> list = mapper.selectByExample(ex); 
		
		if( list.size()>0) {
			return list.get(0);  		// 假设一个老师只教授一门课 
		}else {
			return null;
		}
		
	}

}
