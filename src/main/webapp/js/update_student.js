/**
 *  修改学生的信息 
 */

layui.use(['form','layer'], function(){
	   var form  = layui.form;
	   var layer = layui.layer;
	   var $ = layui.jquery;
	   var APP_PATH = $('input[name="APP_PATH"]').val();
	   
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	  
	  var url = APP_PATH +"/student/updateStudent.do";
	 $("#submit").click(function(){
	
		   var stuId = $('input[name="stuId"]').val();
		   var name = $('input[name="name"]:first').val();
		   var sex = $('input[name="sex"]:checked').val();
		   var contact = $('input[name="contact"]:first').val();
		   var email = $('input[name="email"]:first').val(); 
//		   console.log(APP_PATH);
//		   console.log(stuId);
//		   console.log(name);
//		   console.log(sex);
//		   console.log(contact);
//		   console.log(email);
		
//		 layer.msg("submit"); 		// 通过 ajax 提交信息，返回提交信息
		 
		 $.ajax({
			 type:'post',
			 data:{
				 stuId:stuId,
				 name:name,
				 sex:sex,
				 contact:contact,
				 email:email
			 },
			 url:url,
			 success:function(data){
				 
				 if( data.code="200"){
					 layer.msg("添加成功!")
				 }else{
					 layer.msg("添加失败!");
				 }
			 }
		 });
	 }); 
	});


	function submit(){
		
		
		
	}

