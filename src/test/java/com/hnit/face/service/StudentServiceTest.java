package com.hnit.face.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnit.face.bean.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StudentServiceTest {

	
	@Autowired
	StudentService stuService;
	
	@Test
	public void test() {
		
		String name = "何称";
		String stuId = "18022240330";
		
		List<Student> s = stuService.searchStudent(name, stuId);
		
		System.out.println(s);
		
	}
	
	@Test
	public void test1() {
		
		String name = "%周方荣%";
		String stuId ="%%";
		
		List<Student> s = stuService.searchStudent(name, stuId);
		
		System.out.println(s);
		
	}

}
