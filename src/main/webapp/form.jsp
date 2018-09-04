<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%request.setAttribute("APP_PATH", request.getContextPath()); %>
	<script type="text/javascript" src="${APP_PATH }/js/jquery-1.8.3.min.js"></script>
	
</head>

<body>


	<form method="post" action="${APP_PATH }/test/demo1.do">
		Name : <input type="text" name="name" /> <br/>
		Age : <input type="text" name="age" /><br/>
		<input type="submit" value="Submit" />
		
	</form>
	<input type="button" id="btn" value="Button" onclick="submit()" />
	<script>
		
		function submit(){
			
// 			$("#btn").click(function(){
				var url = "/HelloFace/test/demo1.do";
				$.ajax({
					type:"post",
					url : url,
					data:{
						name:"赵云",
						age:"12"
					},
					success:function(data){
						
						console.log(data);
						
						console.log("success.jsp");
						
					}
				});
				
				
// 			});
			
		}
	
	</script>

</body>
</html>