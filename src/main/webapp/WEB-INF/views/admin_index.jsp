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

		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<div class="layui-logo">Face admin</div>
				<!-- 头部区域（可配合layui已有的水平导航） -->
				<ul class="layui-nav layui-layout-left">
					<li class="layui-nav-item">
						<a href="">控制台</a>
					</li>
					
					<li class="layui-nav-item">
						<a href="javascript:;">其它系统</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="">消息管理</a>
							</dd>
							<dd>
								<a href="">授权管理</a>
							</dd>
						</dl>
					</li>
				</ul>
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a href="javascript:;">
							<img src="http://t.cn/RCzsdCq" class="layui-nav-img">${user.username }
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="">基本资料</a>
							</dd>
							<dd>
								<a href="#" data-method="setpass" class="a_link">安全设置</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="#" id="exit" data-method="exit" class="a_link">退了</a>
					</li>
				</ul>
			</div>

			<div class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree" lay-filter="test">
						
						<li class="layui-nav-item">
							<a href="${APP_PATH }/admin/toLoginPage.do">管理学生信息</a>
						</li>
						<li class="layui-nav-item">
							<a href="${APP_PATH }/apply/toApplyPage.do">管理教师申请</a>
						</li>
						
						
					</ul>
				</div>
			</div>

			<div class="layui-body">
				<!-- 内容主体区域 -->
				欢迎您  <img alt="笑脸" src="${APP_PATH }/img/qute2.png" style="block:inline;">
					，${user.username }
			
		  </div>
			
			<div class="layui-footer">
				<!-- 底部固定区域 -->
				©  acm对外小分队
			</div>
		</div>
		</div>	
	</body>
	
	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script>
	
	<script type="text/html" id="opBar">
	  <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>		<!--这里不是真正的删除了 --> 
	</script>
	
	<script type="text/javascript" src="${APP_PATH }/js/admin_op.js"></script>
	
	
	<script type="text/javascript" id="sexTool">
		<span>{{d.sex==1 ? '男' : '女' }}</span>
	</script>


	
</html>