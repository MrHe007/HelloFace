/**
 * 
 */

layui.use(['element', 'layer','form','table'], function() {
			var element = layui.element;
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.jquery;
			var classId = ""; 		// 为了点击”确定按钮，得到数据"
		var APP_PATH= $("#APP_PATH").val();
		
		layui.use('table', function(){
			var table = layui.table;
		  //第一个实例
		 var tableIns =  table.render({ 		// 将数据加载到表格中
		    elem: '#demo'
		    ,height: 315
		    ,id:"myTable"
//		    ,url: APP_PATH+'/student/getTestStuList.do?classId=3' //数据接口 , 如果不设置，默认不会报 “接口异常操作"
		    ,page: true //开启分页
		    ,cols: [[ //表头
		    {type: 'checkbox', fixed: 'left'},	 		// 表示在前面加一个 选择框 
		      {field: 'stuId', title: 'ID', width:160, sort: true, fixed: 'left'}
		      ,{field: 'name', title: '姓名', width:80}
		      ,{field: 'sex', title: '性别', width:80, templet : '#sexTool' }
		      ,{field: 'contact', title: '联系方式', width:130} 
		      ,{field: 'email', title: '邮件', width: 177}
		      ,{field: 'operation', title: '操作', width: 177,toolbar:'#opBar'}
		    ]]
		  });
		  
		  form.on('select(deptSelect)', function(data){ 		// 监听 select 
//			  console.log(data.elem); //得到select原始DOM对象
//			  console.log(data.value); //得到被选中的值
			  var deptId = data.value; 		// 得到学院的 id
			  var url = APP_PATH +"/major/getMajorList.do"; 
			  $.ajax({
				 type:'post',
				  url:url,
				  data:{
					  'deptId':deptId
				  },
				  success:function(data){ 	// 返回　json 数据（ 通过 deptId 得到的 专业数据 )
//					  console.log( data );
					  console.log("dept -- 返回数据成功!");
					  push_major(data,form); 	// 传入 form 的目的是为了渲染视图  		
				  }
			  });
			});  
		  
		  form.on('select(major)', function(data){ 		// 监听 select 
			  console.log(data.elem); //得到select原始DOM对象
			  console.log(data.value); //得到被选中的值
			  var majorId = data.value; 		// 得到学院的 id
			  var url = APP_PATH +"/class/getClassListByMajorId.do"; 
			  $.ajax({
				 type:'post',
				  url:url,
				  data:{
					  'majorId':majorId
				  },
				  success:function(data){ 	// 返回　json 数据（ 通过 deptId 得到的 专业数据 )
//					  console.log( data );
					  console.log("major -- 返回数据成功!");
					  push_class(data,form); 	// 传入 form 的目的是为了渲染视图  		
				  }
			  });
			});
		  
		  form.on('select(class)', function(data){ 		// 监听 select 
			  
			  classId = data.value; 	
			  console.log("classId = "+classId);
			  
		  });
		  
		 var active = { 		// 下面两个代码块是进行 “勾选” 每行数据前的复选框 操作 
				    getCheckLength: function(){ //获取选中数目
				      var checkStatus = table.checkStatus('myTable')
				      ,data = checkStatus.data;
				      
				      layer.confirm('确定删除这 '+ data.length + ' 行数据？', function(index){
				    	  //do something
				    	  layer.msg("确认!"); 	
				    	  
				    	  // 跳回到服务端，进行数据的删除
				    	  
				    	//   Ajax(); 			// 将所有 ajax 操作放在函数中 
				    	  
				    	  layer.close(index);
				    	});
				    }
		 		};
		  
		 $('.layui-btn-group .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
		});
		 
		 $("#btn_getStudent").click(function(){ 	// 监听“确定”按钮，点击，请求数据渲染数据表
			 
//			 alert("demo");
			 table.reload('myTable', {		// myTable 表示数据表的 id ,是在 js 代码中定义的 
				method:'post',
//				 contentType:"text/html;charset=UTF-8;",
				 url: APP_PATH+'/student/getStudentsByClassId.do'
				  ,where: { //设定异步数据接口的额外参数
					  classId:classId
				  }
			 	});
			});
		 
		 $("#search_student").click(function(){ 	// 监听“确定”按钮，点击，请求数据渲染数据表
			
			 var name = $('input[name="name"]').val();
			 var stuId = $('input[name="stuId"]').val();
			 
			 console.log('name: '+name +" stuId: " +stuId);
			 table.reload('myTable', {		// myTable 表示数据表的 id ,是在 js 代码中定义的 
				 method:'post',
				 url: APP_PATH+'/student/searchStudent.do'
				  ,where: { //设定异步数据接口的额外参数
					  name:name,
					  stuId:stuId
				  }
			 	});
			});
		  
		 $("#add_student").click(function(){ 		// 监听 “增加” 按钮
			 
			 layer.open({
				  type: 2,
				  shade: false,
				  area: ['600px','400px'],
				  skin:'layui-layer-molv',
	    		  maxmin: true,
	    		  content: APP_PATH+'/html/add_student.jsp',
				  zIndex: layer.zIndex, //重点1
				  success: function(layero){
				    layer.setTop(layero); //重点2
				  }
				}); 
		 }); 
		  
		 $("#exit").click(function(){
			
			 layer.confirm('确认退出?', function(index){
				 
				
				  layer.close(index);
				  location.href=APP_PATH +"/admin/louOut.do";
				}); 
			 
		 });
		  
		  table.on('tool(demo)', function(obj){ 	// demo 是数据表的 id ,表示监听数据表里面的“工具”
			// obj 表示的是 tool 中的工具的 id
			  var data = obj.data; 	// 得到 点击数据表的一行
			    if(obj.event === 'detail'){
			      layer.msg('ID：'+ data.id + ' 的查看操作');
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        obj.del();
			        layer.close(index);
			      });
			    } else if(obj.event === 'edit'){
			    	// 点击编辑，弹出一个页面 
//			    	var jsonData = JSON.stringify(data); 	// 这个函数是将 json -> js字符串
			    
			    	layer.open({
			    		  title:'修改学生   '+data.name,
			    		  type: 2,
			    		  shade: false,
			    		  area: ['600px','400px'],
			    		  maxmin: true,
			    		  content: APP_PATH+'/html/update_student.jsp',
			    		  zIndex: layer.zIndex, //重点1
			    		  success: function(dom,index){ 	// 通过当前层的 dom 在的表单赋值 
			    			  console.log(dom, index);		// data 拿到了当前这行的数据，可以通过它赋值给
			    			  
			    			  var body = layer.getChildFrame('body', index); 	// 表示拿到当前 index 层,selector即iframe页的选择器,此时拿到 body
			    			  console.log(body);
			    			 
			    			  var iframeWin = window[dom.find('iframe')[0]['name']]
			    			  var form = iframeWin.layui.form;
			    			  initUpdate(body,iframeWin.layui.form,data);
			    			  
			    			  console.log( iframeWin.form ); 			// 不行
			    			  console.log( iframeWin.layui.form );
			    		  }
			    		}); 
			    	
//			      layer.alert('编辑行：<br>'+ JSON.stringify(data))
			    }
			  });
		});
		
		
		function push_major(data,form){
			
			for(var i=0; i<data.length; i++){
				$("#major").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
			}
			form.render(); 		// 在 select 中添加了新的数据后，需要重新渲染 
		}
		
		function push_class(data,form){
			
			for(var i=0; i<data.length; i++){
				$("#class").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
			}
			form.render(); 
		}
		
		function initUpdate(body,form,data){
			
			 body.find('input[name="name"]').val(data.name);
			  body.find('input[name="stuId"]').val(data.stuId);
			  body.find('input[name="contact"]').val(data.contact);
			  body.find('input[name="email"]').val(data.email);
			  
//			  $(  body.find('input[type="radio"]').get(0) ).removeAttr('checked','true');
//			  $(  body.find('input[type="radio"]').get(1) ).attr('checked','true');
//			  body.find('form').get(0).render();
			
			  if( data.sex=='1'){
				  $( body.find('input[type="radio"]').get(0) ).attr('checked','true');
				  $(  body.find('input[type="radio"]').get(1) ).removeAttr('checked','true');
			  }else{
				 $(  body.find('input[type="radio"]').get(1) ).attr('checked','true');
				 $(  body.find('input[type="radio"]').get(0) ).removeAttr('checked','true');
			  }
			  
			form.render(null,'update-from'); 			// 更新 form 表单 
		}
		
		
	});