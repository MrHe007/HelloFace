/**
 *  增加学生的 javascript 
 */

layui.use(['form','layer'], function(){
	
	   var form  = layui.form;
	   var layer = layui.layer;
	   var $ = layui.jquery;
	   var APP_PATH = $('input[name="APP_PATH"]').val();
	   var flag = true;
	
	   
	   
	   checkInput(layer,$); 			// 监听所 有的输入框 
	   
	   $("#submit").click(function(){
		   var stuId = $('input[name="stuId"]').val();
		   var name = $('input[name="name"]:first').val();
		   var sex = $('input[name="sex"]:checked').val();
		   var contact = $('input[name="contact"]:first').val();
		   var email = $('input[name="email"]:first').val(); 
		   
//		   console.log(stuId);
//		   console.log(name);
//		   console.log(sex);
//		   console.log(contact);
//		   console.log(email);
		   
//		   checkInput(stuId,name,sex,contact,email); 		// 检验 input 是否输入有效值 
		   
		   console.log( APP_PATH );
		   var url = APP_PATH +"/student/addStudent.do";
		   
		   if( flag ==true){ 	// 如果输入的信息均正确，就开始访问
		 
			   $.ajax({
				  type:'post',
				  url:url,
				  data:{
					  stuId:stuId,
					  name:name,
					  sex:sex,
					  contact:contact,
					  email:email
				  },
				  success:function(data){
					  
					  console.log( data );
					  
					  if(data.code=="200"){
						  layer.confirm('添加成功，是否继续添加 ？', function(index){
							  //继续添加
							  // 继续添加应该   清空现有的数据 -- 目前输入框中的数据 
							  layer.close(index);
							},function(index){
								// 关闭整个添加学生的弹出框 
								
							}); 
						  
					  }else{
						  layer.msg("添加失败!");
					  }
				  }
			   });
		   }
	   });
	   
	   function checkInput(layer,$){ // 听
		   var flag = true;
		   $('input[name="stuId"]').on('blur',function(){ 	// 监听 输入 学号的框是否有值 
			   var that = this; 
			   if( !(this.value !="" && this.value.length==11) ){
				   layer.tips('请输入正确的学号格式',that);
				   flag = false;
			   }
			  
		   });
		   
		   $('input[name="name"]').on('blur',function(){ 	// 监听 输入 学号的框是否有值 
			   var that = this; 
			   if( false ){
				   layer.tips('请输入正确的学号格式',that);
				   flag = false;
			   }
			  
		   });
		   
		   $('input[name="sex"]').on('blur',function(){ 	// 监听 输入 学号的框是否有值 
			   var that = this; 
			   if( false){
				   layer.tips('请输入正确的学号格式',that);
				   flag = false;
			   }
			  
		   });
		   
		   $('input[name="contact"]').on('blur',function(){ 	// 监听 输入 学号的框是否有值 
			   var that = this; 
			   if( false){
				   layer.tips('请输入正确的学号格式',that);
				   flag = false;
			   }
			  
		   });
		   
		   $('input[name="email"]').on('blur',function(){ 	// 监听 输入 学号的框是否有值 
			   var that = this; 
			   if( false){
				   layer.tips('请输入正确的学号格式',that);
				   flag = false;
			   }
			  
		   });
	   }
});
