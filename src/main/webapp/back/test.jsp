<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%request.setAttribute("APP_PATH", request.getContextPath()); %>
<title>Insert title here</title>
</head>
<body>

	<a href="${APP_PATH }/major/getMajorList.do?deptId=2"> 测试通过 deptId 返回 Major_List</a> <br>
	
	<a href="${APP_PATH }/major/getClassList.do?teacherId=1"> 测试通过 deptId 返回 Major_List</a>
	
	
</body>
</html>