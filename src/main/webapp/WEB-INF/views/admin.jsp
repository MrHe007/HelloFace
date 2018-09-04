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
							<img src="http://t.cn/RCzsdCq" class="layui-nav-img"> ${user.name }
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
						<a href="#" data-method="exit" class="a_link" >注销</a>
					</li>
				</ul>
			</div>

			<div class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree" lay-filter="test">
						<li class="layui-nav-item layui-nav-itemed">
							<a class="" href="${APP_PATH }/teacher/toAttendenceInfoPage.do">查看签到情况</a>
						</li>
						
					</ul>
				</div>
			</div>

			<div class="layui-body">
				<!-- 内容主体区域 -->
				<div style="padding: 15px;">
					欢迎您  <img alt="笑脸" src="${APP_PATH }/img/qute2.png" style="block:inline;">
					，${user.name }老师 
				</div>
			</div>

			<div class="layui-footer">
				<!-- 底部固定区域 -->
				© acm对外小分队
			</div>
		</div>
	</body>

	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script>
	<script>
		layui.use(['element','layer'], function() {
			var element = layui.element;
			var layer = layui.layer;
			var $ = layui.jquery;
			
			var active = {
				
				exit:function(){
					layer.open({
						content:'确认退出?',
						btn:['退出','不退出'],
						anim:6,
						yes:function(index,layero){
							layer.msg("退出",{time:2000});
							location.href="${APP_PATH}/teacher/logout.do";
						},
						btn2:function(index,layero){
//							alert("不退出")
// 							layer.msg('不退出!',{time:2000});
						}
					});
				}
				,setpass:function(){
//					layer.msg('不退出!',{time:2000});
//					alert("fd");
					layer.open({
						type:2,		// 打开的是一个 iframe
						title:'更新密码',
						skin:'layui-layer-molv',
						content:['${APP_PATH }/html/update_pass.jsp','no'], 	// no 可以让 iframe 不出现滚动条
						anim:1,
						area:['500px','300px'], 			// 设置当前iframe 的范围
						scrollbar:true,
						maxmin:true
					});
				}
			
			}
			
//			$("#exit").click(function(){
//				var othis = $(this);
//				active['confirm'].call(this,othis);
//				
//			});
//			
			$(".a_link").on('click',function(){ 	// 将多个点击事件绑定到 a_link 这个class 中，监听 click 事件
				var othis = $(this);
				var method = othis.data('method');
//				layer.msg(method);
				
				active[method] ? active[method].call(this,othis) : '';
				
			})
			
			

		});
	</script>
</html>