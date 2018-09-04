package com.hnit.face.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnit.face.bean.Student;
import com.hnit.face.bean.StudentExample;
import com.hnit.face.bean.StudentExample.Criteria;
import com.hnit.face.dao.StudentMapper;

@Service
public class StudentService {

	@Autowired
	StudentMapper mapper;
	
	public List<Student> searchStudent(String name,String stuId) {
		
		StudentExample ex = new StudentExample();
		Criteria c = ex.createCriteria();
		c.andNameLike("%"+name+"%"); 				//  mybatis 逆向工程的查找，模糊匹配时，需要加上 %
		c.andStuIdLike("%"+stuId+"%");
		
		List<Student> list = mapper.selectByExample(ex);
		
		System.out.println("dao : "+list);
		
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	
	
	public int getStudentCount() {
		return mapper.getStudentCount();
	}
	
	
	public void deleteStudents(List<String> studIdList) {
		
		for(String id:studIdList) {
			mapper.deleteByPrimaryKey(id);
		}
		
	}
	
	public void addStudent(List<Student> list) {
		
		
		for(int j=0; j<list.size(); j++) {
			mapper.insert(list.get(j));
		}
		
	}
	
	public  List<Student> getStuListByPage(String classId,Integer page,Integer limit){
		
		List<Student> list = null;
		
		list = mapper.getStuListByPage(classId, (page-1)*limit,limit);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	
	public List<Student> getStuList(String classId){
		
		List<Student> list = null;
		
		StudentExample example = new StudentExample();
		
		Criteria c = example.createCriteria();
		c.andClassIdEqualTo(Integer.parseInt(classId));
		
		list = mapper.selectByExample(example);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}


	public boolean addStudent(Student stu) {
		
		int col = mapper.insert(stu);
		if(col>0) {
			return true;
		}else {
			return false;
		}
		
	}


	public boolean updateStudent(Student stu) {
		
		int col =  mapper.updateByPrimaryKeySelective(stu);
		if(col>0) {
			return true;
		}else {
			return false;
		}
	}
	
}


