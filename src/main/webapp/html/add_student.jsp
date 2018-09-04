<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<%request.setAttribute("APP_PATH", request.getContextPath()); %>
	<link rel=" stylesheet" type="text/css" href="${APP_PATH }/layui/css/layui.css" />


</head>
<body>
	
			
	<form class="layui-form" action="${APP_PATH }/student/updateStudent.do" lay-filter='update-from'>
		<input type="hidden" name="APP_PATH" value="${APP_PATH }" />
	  <div class="layui-form-item">
	    <label class="layui-form-label">学号</label>
	    <div class="layui-input-inline">
	      <input type="text" name="stuId" required  lay-verify="required" placeholder="请输入11位的学号" style="width:360px"  autocomplete="off" class="layui-input">
	    </div>
	  </div>
		
	<div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-inline">
	      <input type="text" name="name" required  lay-verify="required" placeholder="请输入名字"  style="width:360px" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-inline">
	      <input type="radio" name="sex" value="1" title="男" checked>
	      <input type="radio" name="sex" value="0" title="女" >
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">联系方式</label>
	    <div class="layui-input-inline">
	      <input type="text" name="contact" required  lay-verify="required" placeholder="请输入联系方式" style="width:360px" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">邮件</label>
	    <div class="layui-input-inline">
	      <input type="text" name="email" required  lay-verify="required" placeholder="请输入邮件" style="width:360px" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	
	 <div class="layui-form-item">
	    <div class="layui-input-block">
	      <a class="layui-btn" id="submit">立即提交</a>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	 </form>
	
</body>

	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script> 
	<script type="text/javascript" src="${APP_PATH }/js/add_student.js"> </script>
	
	<script>

	//Demo
	
	
	
	</script>

</html>