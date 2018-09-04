/**
 *  用于 login.js 中的 js
 */


		layui.use(['layer','form'],function(){
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.jquery;
			
			var APP_PATH = $("#APP_PATH").val();		// 在 jsp 页面设置一个 hidden 页面，存放地址 
//			var url1 ="http://localhost:8088/"+ APP_PATH+"/teacher/login.do"
			var url1 = APP_PATH+"/admin/login.do";
//			form.on('submit(formDemo)',function(data){ 	// data 里面封装了  input 中的字符串的对象
//				
//				var jsondata = JSON.stringify(data.field);
//				alert(jsondata);
//							
//			
////				return false; 		// 如果返回 ture ,则跳转页面
//				return false;
//			})
			
			$("#submit").click(function(){
				
				var username = $('input[name="username"]').val();
				var password = $('input[name="password"]').val();
				var captcha = $('input[name="captcha"]').val();
				var index = layer.load(0, {time: 2*1000,});
//				setTimeout(layer.load(0, {time: 2*1000,}),2000 );		// 使得认证操作持续两秒
				$.ajax({
					type:'POST',
					url:url1,
//					contentType: "application/json",
//					dataType:'json',	// 服务器返回额数据类型 , 可以去掉，因为会自动判断
//					'username='+username+"&password="+password+"&captcha="+captcha,
					data: "username="+username+"&password="+password+"&captcha="+captcha,
					success:function(data){ 		// 返回的是 json 字符串
						
						var code = data.code; 	
						
						if( code=='405'){ 	// 表示登入失败
//							layer.alert(data.msg);
							ReturnError(data.msg);				// 转到自定义处理错误的方法
						}else if(code=='200'){ 	// 身份验证成功
							layer.msg("准备跳转到后台!");
							var url = APP_PATH+"/admin/toAdminOpPage.do";
							window.location.href = url;			// 跳转到后台 
						
						}
					}
				});
				
			});
			
			
			form.verify({
				  username: function(value, item){ //value：表单的值、item：表单的DOM对象
				    if(value.length<3){
				      return '用户名不符合长度规范!';
				    }
				    if(/(^\_)|(\__)|(\_+$)/.test(value)){
				      return '用户名首尾不能出现下划线\'_\'!';
				    }
				    if(/^\d+\d+\d$/.test(value)){
				      return '用户名不能全为数字!';
				    }
				  }
				  
				  //我们既支持上述函数式的方式，也支持下述数组的形式
				  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
				  ,password: [
				    /^[\S]{6,12}$/
				    ,'密码必须6到12位，且不能出现空格!'
				  ] 
				}); 
				
			$("#captcha_img").click(function(){
				
				this.src = APP_PATH+"/util/code.do?time="+new Date(); 	// 因为是 dom 对象，所以可以直接 src
				
			});	
			
			
			function ReturnError(msg){
				
				layer.msg(msg,{
					skin:"ayui-layer-lan",
					area: ['100px', '100px'],
					icon: 5, 			// 可以显示图标
					anim:6,
					time:3000 		
				});
				
			}
			
		});
		
		
		
		
		
