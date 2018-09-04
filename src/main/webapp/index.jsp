<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 	<%request.setAttribute("APP_PATH", request.getContextPath()); %>
	<link href="${APP_PATH }/css/index.css" rel="stylesheet">
</head>

	<body>
	  <div id="ice-container"></div>
	  
	 	<script src="https://g.alicdn.com/code/npm/??react/16.2.0/umd/react.production.min.js,react-dom/16.2.0/umd/react-dom.production.min.js"></script>
		<script type="text/javascript" src="${APP_PATH }/js/index.js"></script>
	
	</body>
</html>