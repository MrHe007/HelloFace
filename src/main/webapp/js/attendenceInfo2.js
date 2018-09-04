/**
 * 
 */

layui.use(['element','layer','form','table'], function() {
			var element = layui.element;
			var layer = layui.layer;
			var $ = layui.jquery;
			var form = layui.form;
			var APP_PATH = $("#app_path").val();
			var teacherId = $("#teacherId").val();
			var name = $("#name").val();
			var $class = $("#class");
			var classId = null;
			var flag = false; 		// 用于标识是否满足请求后台的条件 

			var table = layui.table;
			
			
//			$("#class").append('<option value="">班级</option>'); 		// 测试数据
			
			Ajax_class(APP_PATH,teacherId);
			
			$("#submit").click(function(){
				
				if(flag==true){
//					Ajax_getStudentList(classId);			// 发送 ajax ，得到学生列表
						
					createStuTable(classId);
					
				}else{
					layer.msg("请选择班级",{
						time:2000
					});
				}
			});
			
			
			form.on('select(class)', function(data){ 		// 在这里可以做一些 选择“二级联动“的效果 
				// 当选择了学院后，触发事件，发送 ajax ，请求得到该学院的专业数据 
				  console.log(data.elem); //得到select原始DOM对象
				  console.log(data.value); //得到被选中的值
				  console.log(data.othis); //得到美化后的DOM对象
				  
				  classId = data.value; 			// 得到选择的学院的专业 
				  
				  if(classId==""){
					  layer.msg("请选择班级");
					  flag = false;
				  }else{
					  flag = true;
				  }
			}); 
			
			function Ajax_getStudentList(classId){
				
				url = APP_PATH +"/student/getStuList.do?classId="+classId;
				$.ajax({
					
					type:'post',
					url:url,
					success:function(data){
						console.log(data);
						createStuTable(data);
					}
				});
				
			}
			
			
			function createStuTable(classId){ 	// 此时的 data 数据是 json
				url1 = APP_PATH +"/student/getStuList.do?classId="+classId;
				 table.render({
				    elem: '#demo'
				    ,height: 315
				    ,url:url1		 //数据接口
				    ,page: true //开启分页
				    ,cols: [[ //表头
				      {field: 'className', title: '班级', width:129,  fixed: 'left'}
				      ,{field: 'stuId', title: '学号', width:139 , sort: true}
				      ,{field: 'name', title: '姓名', width:80, sort: true}
				      ,{field: 'email', title: 'email', width:198} 
				      ,{field: 'situation', title: '签到情况',templet:'#renderSex'}
				    ]]
				  });
			}
			
			
			function Ajax_class(APP_PATH,teacherId){
				
				var url = APP_PATH +"/major/getClassList.do?teacherId="+teacherId;
				
				$.ajax({
					type:'post',
					url:url,
					success:function(data){
						
						console.log(data);
						addClassToSelect(data);
					}
				});
			}
		
			function addClassToSelect(data){
				
//				var jsonData = eval ("(" + data + ")");
//				var jsonData = JSON.stringify(data);
				console.log("length = "+ data.length);
//				for(var j=0; j<data.length; j++){			// 输出 json 数组
//					console.log(data[j]);
//				}
				for(var j=0; j<data.length; j++){	
					
					$("#class").append('<option value="'+data[j].id+'">'+data[j].name+'</option>');
				
				}
				
				form.render('select','myForm'); 			// 手动渲染，才可以刷新动态生成的表单  , 至关重要的一部，少了这一部，就不会显示 
				
			}
			
			function exit(){
				
				alert("demo");
				
			}
			
			
});












