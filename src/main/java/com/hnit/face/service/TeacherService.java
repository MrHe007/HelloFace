package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Teacher;
import com.hnit.face.bean.TeacherApply;
import com.hnit.face.bean.TeacherExample;
import com.hnit.face.bean.TeacherExample.Criteria;
import com.hnit.face.dao.TeacherMapper;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper dao;
	
	public Teacher login(String username,String password) {
		
		TeacherExample ex = new TeacherExample();
		Criteria c = ex.createCriteria();
		c.andLoginNameEqualTo(username);
		c.andLoginPassEqualTo(password);
		
		List<Teacher> tea = dao.selectByExample(ex);
		if( tea.size()>0) {
			return tea.get(0); 	// 返回 Teacher
		}else {
			return null; 		//
		}
		
		
	}

	public boolean updatePassword(Teacher record) {
		
		int col = dao.updateByPrimaryKey(record);
		if( col>0) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean addTeacherFromApply(TeacherApply apply) {
		
		Teacher tea = new Teacher(apply.getAcademicId(),apply.getAge(),apply.getName(),apply.getSex()+"",apply.getContact(),apply.getImage(),apply.getLoginName(),apply.getLoginPass(),apply.getState()+"");
		dao.insert(tea); 			
		return true;
	}

	public boolean removeFromApply(TeacherApply apply) {
		
		TeacherExample ex = new TeacherExample();
		Criteria c = ex.createCriteria();
		
		c.andNameEqualTo(apply.getName());
		c.andLoginNameEqualTo(apply.getLoginName());
		c.andLoginPassEqualTo(apply.getLoginPass());
		try {
			dao.deleteByExample(ex); 
			return true;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
}
