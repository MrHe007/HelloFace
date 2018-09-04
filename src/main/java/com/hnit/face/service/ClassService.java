package com.hnit.face.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Class;
import com.hnit.face.bean.ClassExample;
import com.hnit.face.bean.Student;
import com.hnit.face.bean.ClassExample.Criteria;
import com.hnit.face.dao.ClassMapper;

@Service
public class ClassService {

	@Autowired
	ClassMapper mapper;
	
	public Class getClassById(Integer classId) {
	
		Class c = mapper.selectByPrimaryKey(classId);
		return c;
	}
	
	public List<Class> getClassListByMajorId(Integer majorId) {
		
		ClassExample ex = new ClassExample();
		Criteria c = ex.createCriteria();
		
		c.andMajorIdEqualTo(majorId);
		
		List<Class> classList = mapper.selectByExample(ex);
		
		return classList;
	}
	
	
	
}
