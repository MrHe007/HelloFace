package com.hnit.face.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnit.face.utils.GraphicHelper;

@Controller
@RequestMapping("/util")
public class WebUtils {
	
	@RequestMapping("code")
	public void getValidateImg(HttpServletResponse response,HttpServletRequest request ) {
		
		 HttpSession session = request.getSession();  
		  
		    // 从请求中获得 URI ( 统一资源标识符 )  
		    String uri = request.getRequestURI();  
//		    System.out.println("uri : "+uri);       	// 输出 uri
		  
		    final int width = 82; // 图片宽度  
		    final int height = 32; // 图片高度  
		    final String imgType = "jpeg"; // 指定图片格式 (不是指MIME类型)  
		    OutputStream output;
		    String code = null;
			try {
				output = response.getOutputStream();  // 获得可以向客户端返回图片的输出流  
			    code = GraphicHelper.create(width, height, imgType, output);   	// 将输出流传进去 
			} catch (IOException e) {
				e.printStackTrace();
			} 
		                                // (字节流)  
		    // 创建验证码图片并返回图片上的字符串  
		  
		    System.out.println("验证码内容: " + code);  
		  
		    // 建立 uri 和 相应的 验证码 的关联 ( 存储到当前会话对象的属性中 )  
		    session.setAttribute("validateCode", code.toLowerCase());  
		  
		return ;
	}
	
	

}
