package com.hnit.face.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.TeacherApply;
import com.hnit.face.service.TeacherApplyService;
import com.hnit.face.service.TeacherService;
import com.hnit.face.to.MsgDataTo;

@Controller
@RequestMapping("/apply")
public class TeacherApplyController {
	
	@Autowired
	TeacherApplyService service;
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/activeApply")
	@ResponseBody
	public MsgDataTo activeApply(HttpServletRequest request,Integer id,Integer state) {
		
		System.out.println("activeApply");
		MsgDataTo to = new MsgDataTo();
		
		System.out.println(id+" -- "+state);
		try {
			TeacherApply apply = service.getTEaTeacherApplyById(id);
			System.out.println(apply);
			
			boolean flag = service.activeApply(apply,state);  		// 激活 该用户后，将该用户的信息，增加到　teacher 表中
			
			if(flag && state==1) { 		// 表示激活成功，则将 apply 的信息添加到 teacher 表中
				System.out.println("准备添加到教师表中!");
				teacherService.addTeacherFromApply(apply);
			}else {
				// 否则从 teacher 表中删除该用户 
				teacherService.removeFromApply(apply);
			}
			to.setCode("200"); 						// 所有的操作正确 
		}catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("错误");
			e.printStackTrace();
			to.setCode("405");						// 表示出错
		}
		return to;
	}
	
	
	@RequestMapping("/regApply")
	@ResponseBody
	public MsgDataTo regApply(HttpServletRequest request , TeacherApply apply,String captcha) {
		
		System.out.println(apply);
		HttpSession session = request.getSession();
		
		String code = (String)session.getAttribute("validateCode"); 
		MsgDataTo to = new MsgDataTo();
		
		System.out.println("captcha : "+captcha);
		
		if(!code.equals(captcha)) { 		// 如果验证码不匹配
			to.setCode("405");  		// 表示验证码错误
			to.setMsg("验证码错误!");
			return to;
		}else {
			service.saveApply(apply);
			to.setCode("200"); 			// 表示申请成功 
		}
		return to;
	}
	
	@RequestMapping("/toApplyPage")
	public String toApplyPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			return "show_apply";
		}
		
		return "admin_op";
	}
	
	@RequestMapping("/getApplyList")
	@ResponseBody
	public MsgDataTo getApplyList(TeacherApply apply) {
		
		System.out.println("apply_list");
		
//		System.out.println(apply);
		
		MsgDataTo to = new MsgDataTo();
		List<TeacherApply> list = service.getApplyList();
		to.setCount(list.size());
		to.setData(list); 		// 将数据设置进去 
		
		return to;
	}
	
}
