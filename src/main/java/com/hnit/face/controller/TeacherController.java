package com.hnit.face.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Teacher;
import com.hnit.face.service.TeacherService;
import com.hnit.face.to.LoginTo;
import com.hnit.face.to.MsgTo;
import com.hnit.face.to.StudentRegTo;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	
	@ResponseBody
	@RequestMapping("updatePass")
	public MsgTo updatePassword(HttpServletRequest request ) {
		
		// 如果 提交的密码是错误的，就不能更改密码，还需要返回前端，提示验证密码错误
		
		String oldPass = request.getParameter("oldPass");
		MsgTo msg= new MsgTo(); 				// 返回给前端的json 对象
		
		HttpSession session = request.getSession();
		Teacher user = (Teacher) session.getAttribute("user"); 		// 因为登入的时候，将该用户的所有信息，存到了 session 域中
		System.out.println("user"+user);
		System.out.println(oldPass);
		
		if( oldPass==null ||  !oldPass.equals(user.getLoginPass())){
			// 验证密码错误
			msg.setCode("405"); 		
			msg.setMsg("密码错误！");
			return msg;
		}
		
		String newPass = request.getParameter("newPass");
		System.out.println(newPass);
		
		// 如果提交密码是对的，返回前端，密码修改正确
		
		user.setLoginPass(newPass); 		// 更改密码
		
		boolean flag = teacherService.updatePassword( user);
		
		session.setAttribute("user", user); 		// 修改密码成功，更新 session 
		msg.setCode("200");
		msg.setMsg("密码修改成功!");
		
		return msg;
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		Teacher tea = (Teacher) session.getAttribute(("user"));
		
		if(tea!=null) {
			session.removeAttribute("user");	
			System.out.println("session 消除!");
		}
		
		return "login";
	}
	
	@RequestMapping("/toTecherApply")
	public String toTecherApply(HttpServletRequest request) {
		System.out.println("toTecherApply");
		HttpSession session = request.getSession(); 		
		
		return "teacher_apply"; 			// 跳到后台管理界面
	}
	
	@RequestMapping("toAdminPage")
	public String toAdminPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 		
		
		if( session.getAttribute("user")==null) { 	// 说明身份验证成功
			// 这个操作是为了防止人为在浏览器器输入，而不是按照流程登入的
			
			return "login";
			
		}
		
		return "admin"; 			// 跳到后台管理界面
	}
	
	@RequestMapping("toLoginPage")
	public String toLoginPage() {
		
		return "login";
	}
	
	@RequestMapping("toAttendenceInfoPage")
	public String toattendenceInfoPage() {
		
		return "attendenceInfo";
	}
	
	@ResponseBody
	@RequestMapping("login")
	// @RequestBody String username,@RequestBody String password,@RequestBody String captcha
	// 
	public LoginTo login(HttpServletRequest req,String username,String password,String captcha) {
		System.out.println(username+" -- "+password+" -- "+captcha);
		
		username = username.trim();
		password = password.trim(); 			// 把末尾的空格去掉
		
		HttpSession session = req.getSession(); 		
		
		String realCaptcha = (String) session.getAttribute("validateCode");
		System.out.println("realCaptcha : "+realCaptcha);
		
		LoginTo returnObj = new LoginTo();				// 返回前端页面的 json 数据
		
		if(!realCaptcha.equals(captcha)) { 	// 如果验证码错误，跳回登入页
			returnObj.setMsg("验证码错误!"); 			
			returnObj.getData().put("username", username);
			returnObj.getData().put("password", password);
			return returnObj;
		}
		
		Teacher tea = teacherService.login(username, password);
		
		if( tea== null) {
//			returnObj.setCode("405");		// 默认是405, 表示用户名后者密码错误
			returnObj.setMsg("用户名或者密码错误!");
		}else {
			returnObj.setCode("200");
			returnObj.setMsg("登入成功");
			session.setAttribute("user", tea); 		// 登入成功，将该对象存到 session 域中
		}
		
		return returnObj;
	}
	
	
	
	
	
}
