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
				<div style="margin-top: 20px;">
				
				<table class="layui-table" lay-data="{height:315, url:'${APP_PATH}/apply/getApplyList.do', page:true, id:'apply_list'}" lay-filter="test">
				  <thead>
				    <tr>
				      <th lay-data="{field:'id', width:80, sort: true}">ID</th>
				      <th lay-data="{field:'name', width:80}">用户名</th>
				       <th lay-data="{field:'age', width:80}">年龄</th>
				      <th lay-data="{field:'sex', width:80, templet:'#sexTemplet'}">性别</th>
				      <th lay-data="{field:'contact', width:150}">联系方式</th>
				      <th lay-data="{field:'loginName', width:80,}">登入名</th>
				      <th lay-data="{field:'loginPass', width:120,sort: true}">登入密码</th>
				      <th lay-data="{field:'state',title:'激活状态',width:120, templet:'#checkboxState', unresize: true}">激活标识</th>
				    </tr>
				  </thead>
				</table>

				</div>
			</div>
				
		</div>
		</div>	
	</body>
	
	<script type="text/javascript" src="${APP_PATH }/layui/layui.js"></script>
	<script type="text/html" id="checkboxState">
		<!-- 在 input 中设置一个存放 id  的字段 --> 
  		<input type="checkbox" name="state" value="{{d.state}}" tid="{{d.id}}" title="激活" lay-filter="activeState" {{ d.state == 1 ? 'checked' : '' }}>
	</script>
	<script type="text/html" id="sexTemplet">
  		<span>{{ d.sex==1 ? '男' : '女' }} </span>
	</script>
	
	<script type="text/javascript">
	
	layui.use('table', function(){
		var table = layui.table;
		var form = layui.form;
		var $ = layui.jquery;
		
		form.on('checkbox(activeState)', function(obj){
		    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);  	
		    /*
		    	this.value : 标识 第几行
		    	this.name  ： checkbox 的 name
		    	obj.elem.checked  : 标识选中的状态 
		    */
		   
		    var url ="${APP_PATH}/apply/activeApply.do";
		    var tid = obj.elem.attributes.tid.nodeValue;  			// 拿到 tid ，即是申请者的 id
		  
// 		    console.log(obj);
		    
		    layer.confirm('激活  /  冻结', {
		    	  btn: ['激活', '冻结', '取消'] //可以无限个按钮
		    	  ,btn3: function(index, layero){
		    	    //按钮【按钮三】的回调
// 		    	   	console.log(layero);
		    	    
		    	    layer.close(index);
		    	  }
		    	}, function(index, layero){
		    	  //按钮【按钮一】的回调
		    	   layer.msg("确定激活");
		    	
		    	console.log("state = "+state);
		    	
		    	obj.elem.checked = true; 		// 可以用来更改 checkbox  , 直接用布尔值，不用“字符串“
		    	
		    	console.log(obj.elem.attributes); 			// 得到所有的结点属性
		    	console.log(obj.elem.attributes.tid); 		// 使用结点获取属性的值 
		    
		    	form.render();						// 但是需要重新渲染表达
		   		var state = $('input[name="state"]').val();
		    	
		    	Ajax(layer,$,url,tid,1);
		    	
		    	layer.close(index);					// 发送 ajax
		    	}, function(index){
		    		//按钮【按钮二】的回调
		    		layer.msg("不激活");
	 		    	obj.elem.checked = false; 		// 可以用来更改 checkbox  
			    	
	 		    	console.log(obj.elem);
	 		    	form.render();
	 		    	
	 		    	var state = $('input[name="state"]').val();
	 		   		Ajax(layer,$,url,tid,0); 	// 发送 ajax
	 		    	
	 		    	layer.close(index);
		    	});
		    
// 		    layer.confirm("确定激活？",function(index){
		    	
// 		    	layer.msg("确定激活");
		    	
// 		    	console.log("state = "+state);
		    	
// 		    	obj.elem.checked;
// 		    	obj.elem.checked = true; 		// 可以用来更改 checkbox  , 直接用布尔值，不用“字符串“
		    	
// 		    	console.log(obj.elem.attributes); 			// 得到所有的结点属性
// 		    	console.log(obj.elem.attributes.tid); 		// 使用结点获取属性的值 
		    	
// 		    	Ajax(layer,$,url,tid,state);
		    	
// 		    	form.render();						// 但是需要重新渲染表达
// 		    	layer.close(index);					// 发送 ajax
// 		    },function(index){
// 		    	layer.msg("不激活");
// 		    	obj.elem.checked = false; 		// 可以用来更改 checkbox  
		    	
// 		    	Ajax(layer,$,url,tid,state); 	// 发送 ajax
		    	
// 		    	console.log(obj.elem);
		    	
// 		    	form.render();
// 		    	layer.close(index);
		    	
// 		    });
		  });
		  
	});
	
	function Ajax(layer,$,url,id,state){
		
		console.log("ajax = "+id);
		
		$.ajax({
    		type:'post',
    		url:url,
    		data:{
    			id:id,
    			state:state
    		},
    		success:function(data){
    			console.log(data);
    			
    			if(data.code=="200"){
    				
    				if(state==1){
    					layer.msg("激活成功!");
    				}else{
    					layer.msg("冻结用户成功!");
    				}
    				
    			}else{
    				layer.msg("服务器繁忙!");
    			}
    			
    			
    		}
    		
    	});
	}
	
	
	</script>
	
	
</html>