/**
 *  用于 修改密码的页面的 js
 */
layui.use(['layer','form'],function(){
			var layer = layui.layer;
			var form = layui.form;
			
			var $ = layui.jquery; 		// 用于操作jq
			
//			$("input[name='curpass']")[0].blur(function(){
////				layer.msg("hello");
//				alert('f');
//			});
			
			var flag = true; 			// 用于判断是满足密码要求

			$("#curpass").on('blur',function(data){ 	// 用于事件的监听
				var that = this; 	// 表示当前 dom 元素
				value = that.value; 		// 表示当前 input 的值
				
				if( value.length<6 ){
//					layer.tips('密码需要大于6位!',"#curpass",{
//						anima:5			
//					});
					flag = false; 			// 不满足条件
//					$("#curpass_tip").empty();
//					$("#curpass_tip").append('<img src="../img/error2.png" />');
					
					
					layer.tips('密码长度需要大于6位!','#curpass',{
						time:2000
					});

				}else{
					$("#curpass_tip").empty(); 	//如果有红色图标提示则去掉
				}
			});
		
			
			$("#renewPass").on('blur',function(data){ 
				
				value = this.value; 
				if( value.length<6){
					flag = false;
					layer.tips('密码长度需要大于6位!','#renewPass',{
						time:2000
					});
				}else{
					flag = true;
				}
				
			});
			
			$("#newPass").on('blur',function(data){ 
				
				value = this.value; 
				if( value.length<6){
					flag = false;
					layer.tips('密码长度需要大于6位!','#newPass',{
						time:2000
					});
				}else{
					flag = true;
				}
				
			});
			
			
		
			var APP_PATH = $("#APP_PATH").val(); 		// 得到根路径 
			
			
				
				$("#submit_ajax").click(function(){
					
					var oldPass = $('input[name="oldPass"]').val();
		  			var newPass = $('input[name="newPass"]').val();
		  			var renewPass = $('input[name="renewPass"]').val();
		  			alert(oldPass+" "+newPass+" "+renewPass);
		  			
		  			
		  			if( newPass!=renewPass){ 	// 两次密码不同
		  				layer.msg("两次密码输入不不一致!");
		  				flag = false;
		  				return;
		  			}else{
		  				flag = true;
		  			}
		  	  		var data = 'oldPass='+oldPass+'&newPass='+newPass;
		  	  		var url = APP_PATH+"/teacher/updatePass.do";
		  	  		
		  	  	if( flag==true ){ 	// 满足条件就跳转
		  	  		$.ajax({
		  	  			type:'post',
		  	  			url:url,
		  	  			data:data,
		  	  			dataType:'json',
		  	  			success:function(data){
//		  	  				alert(data.msg +" "+data.code);
		  	  				layer.msg(data.msg);
		  	  			}
		  	  		});
		  	  	}
			});
			
			
			temp = null; 		// 用于两次密码是否一致的判断
			form.verify({ 		// 进行表单字段的验证 
				curpass:function(value,item){ 	// 这里的 curpass , 是在 layui-varify 字段里面的字符串，想当于是 id
//					alert("ss");
					if(value.length<6){	
						return '密码长度大于6'
					}
				},
				newpass:function(value,item){
					if(value.length<6){
						return '密码长度应该大于6个字符'
					}
					temp = value;
				},
				renewpass:function(value,item){
					
					if(value.length<6){
						return '密码长度应该大于6个字符'
					}
					if(value!=temp){
						return '两次输入密码不一致'
					}
				}
			});
			
			
//			 form.on('submit(formDemo)', function(data){
//			    layer.alert(JSON.stringify(data.field), {
//			      title: '最终的提交信息'
//			    });
//			    return false;		// 默认是 return true,false 表示放弃提交
//			  });
			
			// 监听 form 表单的数据，原密码，新密码满足正则表达式规则,检查两次密码是否一致
			
		});
