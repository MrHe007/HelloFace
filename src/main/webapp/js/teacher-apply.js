/**
 *  用于 login.js 中的 js
 */


		layui.use(['layer','form'],function(){
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.jquery;
			
			var APP_PATH = $("#APP_PATH").val();		// 在 jsp 页面设置一个 hidden 页面，存放地址 
//			var url1 ="http://localhost:8088/"+ APP_PATH+"/teacher/login.do"
			var url1 = APP_PATH+"/apply/regApply.do";
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
				
				
				var flag = checkInput(layer); 			// 验证信息的操作放在方法中 
				
				
				if(flag){
					
					var name = $('input[name="name"]').val();
					var contact = $('input[name="contact"]').val();
					var username = $('input[name="username"]').val();
					var repassword = $('input[name="password"]').val();
					var password = $('input[name="password"]').val();
					var sex = $('input[name="sex"]').val();
					var captcha = $('input[name="captcha"]').val();
					
					console.log("准备跳转到后台!");
	//				setTimeout(layer.load(0, {time: 2*1000,}),2000 );		// 使得认证操作持续两秒
					var captcha = $('input[name="captcha"]').val();
					$.ajax({
						type:'POST',
						url:url1,
	//					contentType: "application/json",
	//					dataType:'json',	// 服务器返回额数据类型 , 可以去掉，因为会自动判断
	//					'username='+username+"&password="+password+"&captcha="+captcha,
						data:{
							name:name,
							contact:contact,
							loginName:username,
							loginPass:password,
							sex:sex,
							captcha:captcha
						},
						success:function(data){ 		// 返回的是 json 字符串
							
							var code = data.code; 	
							
							if( code=='405'){ 	// 表示登入失败
	//							layer.alert(data.msg);
								ReturnError(data.msg);				// 转到自定义处理错误的方法
							}else if(code=='200'){ 	// 身份验证成功
								layer.alert('申请成功，等待管理员申请..', {icon: 1});
								var url = APP_PATH+"/index.jsp";
								location.href = url; 		// 跳转到主页 
							}
						}
					});
				}
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
			
			
			function checkInput(layer){
				var name = $('input[name="name"]').val();
				var contact = $('input[name="contact"]').val();
				var username = $('input[name="username"]').val();
				var repassword = $('input[name="password"]').val();
				var password = $('input[name="password"]').val();
				var sex = $('input[name="sex"]').val();
				var captcha = $('input[name="captcha"]').val();
				
//				var index = layer.load(0, {time: 2*1000,});
				var flag = true;
				console.log(name+" "+contact+" "+username+" "+repassword+" "+password+" "+sex+" "+captcha);
				
				if( contact.length != 11){
					layer.tips('请输入正确的电话号码','#contact');   		// 电话格式错误
					flag = false;
				}
				
				if( !(password == repassword)){
					flag = false;
					layer.tips('两次密码不一致!','#repassword'); 
				}
				
				if(captcha.length!=4){
					flag = false;
					layer.tips('验证码格式不对!','#repassword'); 
				}
				
				return flag;
				
			}
			
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
		
		
		
		
		
