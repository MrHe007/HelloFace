<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%request.setAttribute("APP_PATH", request.getContextPath()); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=" stylesheet" type="text/css" href="${APP_PATH }/layui/css/layui.css" />	
		<link rel=" stylesheet" type="text/css" href="${APP_PATH }/css/teacher-apply.css" />	
</head>
<body>
		<div class="box">
			<div class="reg">
				
			<form class="layui-form" action="${APP_PATH }/teacher/login.do" method="post">
				<input type="hidden" id="APP_PATH" value="${APP_PATH }" />
				<div class="layui-form-item">
				   <h1 id="title">教师注册</h1>
				    
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">
				    	<img src="${APP_PATH }/img/user_icon.png"  />
				    </label>
				    <div class="layui-input-block">
				      <input type="text" name="name" required  lay-verify="name" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
				    </div>
				  </div>
					
				  <div class="layui-form-item">
				    <label class="layui-form-label">
				    	<img src="${APP_PATH }/img/user_icon.png"  />
				    </label>
				    <div class="layui-input-block">
				      <input type="text" name="username" required  lay-verify="username" placeholder="请输入登入名" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  
				    <div class="layui-form-item">
				    <label class="layui-form-label">
				    	<img src="${APP_PATH }/img/password_icon.png" />
				    </label>
				    <div class="layui-input-inline">
				      <input type="password" name="password" required lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    </div>
				    <div class="layui-form-mid layui-word-aux"></div>
				  </div>
				  
				    <div class="layui-form-item">
				    <label class="layui-form-label">
				    	<img src="${APP_PATH }/img/password_icon.png" />
				    </label>
				    <div class="layui-input-inline">
				      <input type="password" name="repassword" id="repassword" required lay-verify="password" placeholder="确定密码" autocomplete="off" class="layui-input">
				    </div>
				    <div class="layui-form-mid layui-word-aux"></div>
				  </div>
				  
				<div class="layui-form-item">
				    <label class="layui-form-label">
				    	<img src="${APP_PATH }/img/contact.png"  />
				    </label>
				    <div class="layui-input-block">
				      <input type="text" name="contact" id="contact" required  lay-verify="contact" placeholder="请输入联系方式" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				
				   <div class="layui-form-item" style="color:white">
				    <label class="layui-form-label"><img src="${APP_PATH }/img/sex.png"  /></label>
				    <div class="layui-input-inline">
				      <input type="radio" name="sex" value="1" title="男">
				      <input type="radio" name="sex" value="0" title="女" checked>
				    </div>
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">
				    	<img src="${APP_PATH }/img/captcha_icon.png"  />
				    </label>
				    <div class="layui-input-inline">
				      <input type="text" name="captcha" required  lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
				    </div>
				    <div class="layui-form-mid layui-word-aux">
				    	<img src="${APP_PATH }/util/code.do" width="80px" id="captcha_img" />
				    </div>
				  </div>
				
				 <div class="layui-form-item">
				    <div class="layui-input-block">
				      <a class="layui-btn  layui-btn-radius" id="submit" >立即提交</a>
				      <button type="reset" class="layui-btn   layui-btn-radius" style="margin-left:80px;">重   &nbsp;&nbsp;置</button>
				    </div>
				  </div>
				  </form>
			</div>
		</div>
	</body>
	
	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script>
	<script type="text/javascript" src="${APP_PATH }/js/teacher-apply.js"></script>
	
	<script>

	</script>
</html>