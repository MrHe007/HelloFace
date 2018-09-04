package com.hnit.face.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Register;
import com.hnit.face.bean.Student;
import com.hnit.face.bean.Teacher;
import com.hnit.face.service.ClassService;
import com.hnit.face.service.RegisterService;
import com.hnit.face.service.StudentService;
import com.hnit.face.to.MsgTo;
import com.hnit.face.to.StudentAttendeceTo;
import com.hnit.face.to.StudentRegTo;
import com.hnit.face.to.StudentsTo;
import com.hnit.face.utils.CommonUtils;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentService service;
	
	@Autowired
	ClassService classService;
	
	@Autowired
	RegisterService registerService;
	
	
	@RequestMapping("/updateStudent.do")
	@ResponseBody
	public MsgTo updateStudent(HttpServletRequest request,Student stu) {
		
		MsgTo msg = new MsgTo();
		System.out.println("stu : "+stu);
		try {
			service.updateStudent(stu);
			msg.setCode("200");
			System.out.println("修改学生信息成功!");
		}catch (Exception e) {
			System.out.println("修改学生信息失败!");
			msg.setCode("405");
		}
		return msg;
	}
	
	@RequestMapping("/addStudent.do")
	@ResponseBody
	public MsgTo addStudent(HttpServletRequest request,Student stu) {
		
		System.out.println(stu);
		MsgTo msg = new MsgTo();
		
		try {
			boolean flag = service.addStudent(stu);
			if(flag) {
				msg.setCode("200"); 		// 表示添加成功 
			}else {
				msg.setCode("405");
			}
		}catch (Exception e) {
			System.out.println((e.toString()) );  	// 打印出出错原因
			System.out.println("添加学生失败!");
		}
		
		return msg;
	}
	
	
	
	@RequestMapping("getStudentsByClassId")
	@ResponseBody
	public StudentsTo getStudentsByClassId(HttpServletRequest request,String classId,Integer page,Integer limit) {
		
		System.out.println("getStudentsByClassId");
		
		List<Student> list = service.getStuListByPage(classId, page, limit);		
		if(list.size()>0) {
			System.out.println(list);
			StudentsTo to = CommonUtils.convertStudentToStudentsTo(list);
			to.setCount(service.getStudentCount()); 		// 首先得到学生的人数  ， 实际上应该得到 该班级下的学生的人数
			return to;
		}
		
		return null; 		// 否则返回 null , 表示返回空的数据 
	}
	// ,produces={"text/html;charset=UTF-8;","application/json;"}
	@RequestMapping(value="searchStudent") 		// 配置 spring mvc -- ajax 异步请求 中文乱码的情况
	@ResponseBody
	public StudentsTo searchStudent(HttpServletRequest request,String name,String stuId,Integer page,Integer limit) {
		
		// 联合查询
		System.out.println(name +" "+ stuId); 		// 转化前 是乱码的 
//		name = CommonUtils.strFromIsoToUtf(name);
//		System.out.println(name +" "+ stuId);
		
		List<Student> stus = service.searchStudent(name, stuId);
		
//		System.out.println(stus);
		
		if(  stus!=null ) {
			if(  stus.size()>0) {
				StudentsTo to = CommonUtils.convertStudentToStudentsTo(stus);
				to.setCount(stus.size()); 			// 告诉数据表有多少行数据发过来
				return to;
			}
		}
		
		return new StudentsTo();
	}
	
	@RequestMapping("getStuList")
	@ResponseBody
	public StudentAttendeceTo getStuList(HttpServletRequest request,String classId,Integer page,Integer limit){
		
		System.out.println(page +" -- "+limit);
		
		HttpSession session = request.getSession(); 		
		Teacher user = (Teacher)session.getAttribute("user");
		Integer teacherId = user.getId(); 			// 得到当前教师 id
		System.out.println("classId -- = "+classId);
		String className = classService.getClassById(Integer.parseInt(classId.trim())).getName(); 		// 得到班级名称
		
		List<Student> stuList = service.getStuListByPage(classId,page,limit);
		
		List<StudentRegTo> list = new ArrayList<>();
		
		for(Student s :stuList) {
			String stuId = s.getStuId();
			Register r = registerService.getRegister(classId, stuId, teacherId);
			list.add( new StudentRegTo(className,stuId,s.getName(),s.getEmail(),r.getSituation()));
		}
		
		StudentAttendeceTo jsonObj = new StudentAttendeceTo(); 		// 为了准守 layui 的数据表格的接口规范
		jsonObj.setCount(service.getStudentCount()); 		// 表示有多少条数据 
		jsonObj.setData(list);
		
//		System.out.println(list);
		
		return jsonObj;
	}
	
	// 下面是测试用 
	@RequestMapping("getTestStuList")
	@ResponseBody
	public StudentsTo getTestStuList(HttpServletRequest request,String classId,Integer page,Integer limit){
		
		System.out.println("getTestStuList");
		
		System.out.println(classId+" "+page+" "+limit);
		
		StudentsTo to = CommonUtils.convertStudentToStudentsTo(service.getStuList("3"));
		to.setCount(service.getStudentCount());
		
		return to;
	
	}
	
}
