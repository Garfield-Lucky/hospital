 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var page = 0;
 var pageSize = 5; 
 
$(function(){
	  $(".query").find('.find').click(function(){
			 var userId =  $('.userId').val();
			 //还原偏移量
			 offset = 0;
			 page = 0;
			 if(userId != '')
			 {
			 $.ajax({
					type : "POST",
					url : "register/backRegisterFind.do",
					async:false,
					data : {
						'userId':userId,
						'page':page,
						'pageSize':pageSize
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
								{
								   $('.pagePosition').show();
								}else{
									  $('.pagePosition').hide();
								}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							$('.userId').attr('data-id',userId);
							 tuihao();
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
			 }else{
				 alert('请输入用户id');
			 }
		     });	
	
	//首页
		 $("#session1").on("click", "#firstPage",  function() {
			    pageA(0,0);
			    var userId =  $('.userId').attr('data-id');
			    $.ajax({
					type : "POST",
					url : "register/backRegisterFind.do",
					async:false,
					data : {
						'userId':userId,
						'page':page,
						'pageSize':pageSize
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
							{
							   $('.pagePosition').show();
							}else{
								  $('.pagePosition').hide();
							}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							tuihao();
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
				 
			});
		 //上一页
		 $("#session1").on("click", "#prevPage",  function() {
			    pageA(2,0);
			    var userId =  $('.userId').attr('data-id');
			    $.ajax({
					type : "POST",
					url : "register/backRegisterFind.do",
					async:false,
					data : {
						'userId':userId,
						'page':page,
						'pageSize':pageSize
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
							{
							   $('.pagePosition').show();
							}else{
								  $('.pagePosition').hide();
							}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							tuihao();
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
				 
			});
		 //下一页
		 $("#session1").on("click", "#nextPage",  function() {
			 pageA(1,0);
			 var userId =  $('.userId').attr('data-id');
			    $.ajax({
					type : "POST",
					url : "register/backRegisterFind.do",
					async:false,
					data : {
						'userId':userId,
						'page':page,
						'pageSize':pageSize
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
							{
							   $('.pagePosition').show();
							}else{
								  $('.pagePosition').hide();
							}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							tuihao();
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
				 
			});
		 //尾页
		 $("#session1").on("click", "#trailPage",  function() {
			    pageA(3,0);
			    var userId =  $('.userId').attr('data-id');
			    $.ajax({
					type : "POST",
					url : "register/backRegisterFind.do",
					async:false,
					data : {
						'userId':userId,
						'page':page,
						'pageSize':pageSize
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
							{
							   $('.pagePosition').show();
							}else{
								  $('.pagePosition').hide();
							}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							tuihao();
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
				 
			});
		 //跳页
		 $("#session1").on("click", "#query",  function() {
			    var pageTo = $("#pageNum").val();
			    pageA(4,pageTo);
			    var userId =  $('.userId').attr('data-id');
			    $.ajax({
					type : "POST",
					url : "register/backRegisterFind.do",
					async:false,
					data : {
						'userId':userId,
						'page':page,
						'pageSize':pageSize
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
							{
							   $('.pagePosition').show();
							}else{
								  $('.pagePosition').hide();
							}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							tuihao();
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
				 
			});
	 });

	//分页
	function pageA(state,pageTo){
	   var t1=dataNum%pageSize;
	   var t2=parseInt(dataNum/pageSize);
	   if(t1 != 0){
		    t2=t2+1;
		 }
		   switch(state)
		   {
			      case 0:
			    	     offset = 0;
			    	  break;
			      case 1:
			    	  if(((offset) < (dataNum - dataNum%pageSize) && dataNum%pageSize != 0)||((offset+pageSize)<(dataNum - dataNum%pageSize) && dataNum%pageSize == 0))
			    	  {
			    	     offset += pageSize;
			    	  }else{
			    		  alert('到尾页了');
			    	  }
			    	  break;
			      case 2:
			    	  if(offset > 0)
			    	  {
			    		offset -= pageSize;
			    	  }else{
			    		offset = 0;
			    		alert('到首页了');
			    	  }
			    	  break;
			      case 3:
					     offset = (t2-1)*pageSize;
			    	  break;
			      case 4:
			    	  if(pageTo == null || pageTo == -1)
			    	  break;
		 	  
		 		  if(pageTo <= t2)
		 		  {
		 		    offset = (pageTo-1)*pageSize;
		 		  }else{
					offset = (t2-1)*pageSize;//尾页
		 		  }
			    	  break;
			      default:break;
		   }
		   page = offset; //该page表示偏移量
		 
	}
 
 function tuihao(){
	  
	 $("#session1").find('.back').click(function(){
		 var vistId =  $(this).attr('data-vistId');
		 var status =  $(this).attr('data-status');
		 if(status == '2')
		 {
		   alert('该号已就诊完成，无法退号！');
		   
		 }else if(status == '3'){
			 alert('该号已退号！');
		 }else{
			 
			var b = window.confirm('你确定要退号吗？');
			if(b)
			{
			 $.ajax({
					type : "POST",
					url : "register/tuihao.do",
					async:false,
					data : {
						'vistId':vistId
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#register_list').html(departmentList4(data.list));
							tuihao();
						}else{
							alert('退号失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
			  }
		 }
	   });
 }