<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%request.setAttribute("APP_PATH", request.getContextPath()); %>
	<link rel=" stylesheet" type="text/css" href="${APP_PATH}/layui/css/layui.css" />
	<title>Insert title here</title>
</head>
<body>

		<div id="box" style="margin-top: 20px;width: 450px;height: 300px;">
			<form class="layui-form" action="">
				<input type="hidden" id="APP_PATH" value="${APP_PATH }">
				<div class="layui-form-item">
					<label class="layui-form-label">当前密码</label>
					<div class="layui-input-inline">
						<input type="text" id="curpass" name="oldPass" required lay-verify="curpass" placeholder="请输入当前密码" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux" id="curpass_tip">
						<!--<img src="../img/error2.png" />-->
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline">
						<input type="text" name="newPass" required lay-verify="newpass" id="newPass" placeholder="请输入新密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认密码</label>
					<div class="layui-input-inline">
						<input type="text" name="renewPass" required lay-verify="renewpass" id="renewPass" placeholder="请确定密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" type="button" id="submit_ajax">立即提交</button>
<!-- 						<input class="layui-btn" id="submit_ajax" value="立即提交"/> -->
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
</body>

	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script>
	<script type="text/javascript" src="${APP_PATH }/js/update_pass.js"></script>

</html>