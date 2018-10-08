$(function(){
	//要想使用jquery的ajax，必须引入jquery的架包
	//绑定事件的方式可以根据id，class根据id去绑定事件是#,class 是.
	$("#username").focus(function(){
		 $("#name").html('');
	});
	$("#password").focus(function(){
		 $("#pwd").html('');
	});
	//检查密码是否合法
	$("#password").blur(function(){
		var password = encodeURI($("#password").val());
		 if(password.length<6||password.length>16)
			 {
			   $("#pwd").css("color","red").html('密码不合法');
			    return;
			 }else{
				 $("#pwd").css("color","green").html('通过');
			 } 
	});
	//检查用户名是否合法
	$("#username").blur(function(){
		var username = encodeURI($("#username").val());
		var myreg = /^1[3458]\d{9}$/;
		if (!myreg.exec(username)){
			   $("#name").css("color","red").html('用户名不合法');
			   console.log('用户名不合法');
			    return;
			 }else{
				 $("#name").css("color","green").html("通过");
			 }
		$.ajax({
			url:"register_check.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				"name":username,
			},cache:false,
			success:function(data){	
				if(data.flag=="false"){
					 $("#name").css("color","green").html('通过');
				}else{
					 $("#name").css("color","red").html('用户名已存在');
				}
				
			},error : function(data) {
				alert("error")
			}
		});	
	});
	//注册按钮
	$("#submit").on("click",function(){
		var name = encodeURI($("#username").val());
		var password = encodeURI($("#password").val());
		
		$.ajax({
			url:"adduserAjax.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				"name":name,
				"password":password//传输参数
			},cache:false,
			success:function(data){	
				if(data.status=="0000"){
					$("#show").html('注册成功');
					$("#username").val('');
					$("#password").val('');
					$("#name").html('');
					$("#pwd").html('');
				}else{
					$('#show').html('注册失败');
					$("#username").html('');
					$("#password").html('');
					$("#name").html('');
					$("#pwd").html('');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
	})
	//查看所有用户按钮
	$('#claid').on("click", function() {
		$("#show").html('');
		$.ajax({
			url:"testact.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				 
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				//注册一个Handlebars Helper,用来将索引+1，因为默认是从0开始的
				var handleHelper = Handlebars.registerHelper("addOne",function(index,options){
		           return parseInt(index)+1;
		         });
				if(data.status=="0000"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('查询失败');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
		
	});
	//更新按钮
	$(document).on("click", ".update",  function() {
		var id =$(this).val();
		//alert(id);
		window.location.href="userUpdate.do?id="+id;
	});
	//删除按钮
	$(document).on("click", ".delete",  function() {
		//alert($(this).val());
		$("#show").html('');
		var id =$(this).val();
		var b = window.confirm('你确定要删除该用户吗？');
		if(b)
		{
		$.ajax({
			url:"delById.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				"id":id
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				if(data.status=="sucess"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('删除失败');
				}
				
			},error : function(data) {
				alert('删除异常')
			}
		});	
		}//if
	});
	
	
	//分页查询
	$(document).on("click", "#firstPage",  function() {
		$("#show").html('');
		$.ajax({
			url:"listPage.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				 "state":"0"
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				// console.log(departmentList4(data.list));
				if(data.status=="0000"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('查询失败');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
		 
	});
//下一页
	$(document).on("click", "#nextPage",  function() {
		$("#show").html('');
		$.ajax({
			url:"listPage.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				 "state":"1"
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				if(data.status=="0000"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('查询失败');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
		 
	});
	//下一页
	$(document).on("click", "#prevPage",  function() {
		$("#show").html('');
		$.ajax({
			url:"listPage.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				 "state":"2"
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				if(data.status=="0000"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('查询失败');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
		 
	});
	
//	尾页
	$(document).on("click", "#trailPage",  function() {
		$("#show").html('');
		$.ajax({
			url:"listPage.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				 "state":"3"
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				if(data.status=="0000"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('查询失败');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
		 
	});
	$(document).on("click", "#query",  function() {
		$("#show").html('');
		var page = $("#pageNum").val();
		if(page.trim()=="")
			page =- 1;
		$.ajax({
			url:"listPage.do",//指定路径
			dataType:"json",
			type:"POST",
			data:{
				 "state":"4",
				 "skip":page
			},cache:false,
			success:function(data){	
				var departmentList4 = Handlebars.compile($("#departmentList4").html());
				    $("#pageNum").val("");
				if(data.status=="0000"){
					$("#tsett1").html(departmentList4(data.list));
					$('#pageNo').html(data.pageNo);
					$('#countPage').html(data.countPage);
				}else{
					$('#tsett1').html('查询失败');
				}
				
			},error : function(data) {
				alert('error')
			}
		});	
		 
	});
});
