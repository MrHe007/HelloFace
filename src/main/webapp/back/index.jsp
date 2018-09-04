<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%request.setAttribute("APP_PATH", request.getContextPath()); %>
</head>
<body>

	<h1>Demo.jsp</h1>
		
	<a href="${APP_PATH }/teacher/toLoginPage.do">老师登入</a> </br>
	
	
	<a href="${APP_PATH }/admin/toLoginPage.do">管理员登入</a>
	

</body>
</html>