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
<body style="background-color:#F2F2F2;">

	<div style="width:320px;margin:0 auto;" >
			<i style="font-size:320px; " class="layui-icon" face></i>
		
	</div>
	
	<div  >
		<hr class="layui-bg-green" style="height:10px;width:700px;margin:50px auto;" >
	</div>
	
	<div style="margin:0 auto;width:400px;margin-top:150px;" >
		<h1 style="font-size:50px;color:#009688"  >服务器繁忙...</h1>
	</div>
	

</body>

	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script> 
	
	<script>
		layui.use(['layer'], function(){
			
			
				
		
		});
	</script>

</html>