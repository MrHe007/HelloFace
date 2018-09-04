/**
 * 
 */

layui.use(['element','layer','form'], function() {
			var element = layui.element;
			var layer = layui.layer;
			var $ = layui.jquery;
			var form = layui.form;
			
			
//			console.log( $("#dept ~ div") );
//			console.log( $("#dept ~ div")[0].childNodes );
//			console.log( $("#dept ~ div")[0].childNodes[1])
//			$('select[name="dept"]').append('<option value="">你好</option>');
//			$( $("#dept ~ div")[0].childNodes[1] ).append('<dd lay-value="" class>你好</dd>');; 	// 这种方法可以，但是不知道是否可以提交到后台
//			
			form.on('select(dept)', function(data){
				// 当选择了学院后，触发事件，发送 ajax ，请求得到该学院的专业数据 
				  console.log(data.elem); //得到select原始DOM对象
				  console.log(data.value); //得到被选中的值
				  console.log(data.othis); //得到美化后的DOM对象
				  
				  var deptId = data.value; 			// 得到选择的学院的专业 
				  
			}); 
});

