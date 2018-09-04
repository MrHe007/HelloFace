package com.hnit.face.controller;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnit.face.bean.Admin;
import com.hnit.face.service.AdminService;
import com.hnit.face.to.MsgTo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;

	@ResponseBody
	@RequestMapping("login")
	public MsgTo login(HttpServletRequest request,String username,String password ) {
	
		Admin admin = service.login(username, password);
		
		System.out.println(admin);
		
		HttpSession session = request.getSession();
		
		MsgTo msg = new MsgTo(); 			// 返回 json 数据的临时对象
		
		if(admin!=null) {
			session.setAttribute("user", admin);   	// 登入成功，放在当前的会话域中
			System.out.println("登入成功！");
			msg.setMsg("登入成功!");
			msg.setCode("200");
			return msg;
		}else {
			msg.setMsg("用户名或者密码错误");
			msg.setCode("405");
			return msg;
		}
	}
	
	@RequestMapping("louOut")
	public String loutOut(HttpSession session ) {
		Admin admin = (Admin) session.getAttribute("user");
		System.out.println(admin);
		
		if( admin != null) {
			return "admin_login";
		}else {
			return "admin_login";
		}
	}
	
	@RequestMapping("toAdminOpPage")
	public String toAdminOpPage(HttpServletRequest request ) {
	
		HttpSession session = request.getSession();
		
		if( session.getAttribute("user") !=null) {
			return "admin_index";
		}
		
		return "error/error.jsp";			// 表示出错界面
	}
	
	@RequestMapping("toLoginPage")
	public String toLoginPage(HttpServletRequest request ) {
	
		HttpSession session = request.getSession();
		
		if( session.getAttribute("user")!=null) { 		// 如果已经登入，直接跳转到后台
			return "admin_op";  	
		}
		
		return "admin_login";
	}
	
	
}
