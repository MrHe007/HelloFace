package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Register;
import com.hnit.face.bean.RegisterExample;
import com.hnit.face.bean.RegisterExample.Criteria;
import com.hnit.face.dao.RegisterMapper;

@Service
public class RegisterService {

	@Autowired
	RegisterMapper mapper;
	
	public void deleteData(List<Integer> regIdList) {
		
		for( Integer id:regIdList) {
			mapper.deleteByPrimaryKey(id);
		}
		
	}
	
	public void addData(List<Register> list) {
		
		for(Register r :list) {
			mapper.insert(r);
		}
	}
	
	public Register getRegister(String classId,String stuId,Integer teacherId) {
		
		RegisterExample ex = new RegisterExample();
		Criteria c = ex.createCriteria();
		
		c.andClassIdEqualTo(new Integer(classId));
		c.andStudentIdEqualTo(stuId);
		c.andTeacherIdEqualTo(teacherId);
		
		List<Register> list = mapper.selectByExample(ex);
		
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
	
}
