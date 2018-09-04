<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%request.setAttribute("APP_PATH", request.getContextPath()); %>
<link rel=" stylesheet" type="text/css"
	href="${APP_PATH }/layui/css/layui.css" />
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">Face admin</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> ${user.name }
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="#" data-method="setpass" class="a_link">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item">
					<a href="javascript:exit()" class="a_link">注销</a>
				</li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					
					<li class="layui-nav-item"><a href="${APP_PATH }/teacher/toAttendenceInfoPage.do">查看签到情况</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<div>
			<form class="layui-form" action="" lay-filter="myForm">
				<input id="app_path" value="${APP_PATH }" type="hidden">
				<input id="teacherId" value="${user.id }" type="hidden">
				<input id="name" value="${user.name}" type="hidden">
				<div class="layui-form-item" style="margin:20px 20px;" id="deptDiv">
					<div class="layui-input-inline">
						<select name="class" lay-verify="required" id="class" lay-filter="class">
							<option value="">班级</option>
						</select>
					</div>
					<input  class="layui-btn" id="submit" type="button"  style="margin-left:50px;width:100px;" value="查询" />
				</div>
				</form>
				
			</div>

		<hr class="layui-bg-green"> 		<!-- 分割线 -->

		<!-- 下面是数据表 -->
		
		<table id="demo" lay-filter="test"></table>

		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© acm对外小分队
		</div>
	</div>
</body>

<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script>
<script type="text/javascript" src="${APP_PATH}/js/attendenceInfo2.js" ></script>

<script type="text/javascript" id="renderSex">
	
	<span>{{d.situation== 'y' ? '<font >Y</font>': '<font color="red">N</font>'   }}</span>


</script>






</html>