 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var flag = 0;
 var page = 0;
 var pageSize = 5;
 
$(function(){
	 diagnose();
	 findDiagnose();
	 bindEvent();
	 
	//首页
	 $("#session1").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var vistId =  $('.vistId').attr('data-vistId');
			var userName =  $('.userName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/findRegisterByVistId.do",
				async:false,
				data : {
					'vistId':vistId,
					'userName':userName,
					'flag':flag,
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
						bindEvent();
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
		    var vistId =  $('.vistId').attr('data-vistId');
			var userName =  $('.userName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/findRegisterByVistId.do",
				async:false,
				data : {
					'vistId':vistId,
					'userName':userName,
					'flag':flag,
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
						bindEvent();
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
		 var vistId =  $('.vistId').attr('data-vistId');
			var userName =  $('.userName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/findRegisterByVistId.do",
				async:false,
				data : {
					'vistId':vistId,
					'userName':userName,
					'flag':flag,
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
						bindEvent();
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
		    var vistId =  $('.vistId').attr('data-vistId');
			var userName =  $('.userName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/findRegisterByVistId.do",
				async:false,
				data : {
					'vistId':vistId,
					'userName':userName,
					'flag':flag,
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
						bindEvent();
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
		    var vistId =  $('.vistId').attr('data-vistId');
			var userName =  $('.userName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/findRegisterByVistId.do",
				async:false,
				data : {
					'vistId':vistId,
					'userName':userName,
					'flag':flag,
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
						bindEvent();
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
 //分页结束
 function bindEvent(){
	 
	 $(".table").find('.presForm').click(function(){
	   	  var vistid = $(this).attr('data-vistId');
	   	  var userId = $(this).attr('data-userId');
	   	  var userName = $(this).attr('data-userName');
		 $('.mainbody_right').load("pres/showForm.do",{vistid:vistid,userId:userId,userName:userName});
	     });
     $(".table").find('.diagnoseForm').click(function(){
    	  var vistid = $(this).attr('data-vistId');
       	  var userId = $(this).attr('data-userId');
       	  var userName = $(this).attr('data-userName');
		 $('.mainbody_right').load("register/showForm.do",{vistid:vistid,userId:userId,userName:userName});
	     });
     $(".table").find('.checkForm').click(function(){
    	  var vistid = $(this).attr('data-vistId');
       	  var userId = $(this).attr('data-userId');
       	  var userName = $(this).attr('data-userName');
		 $('.mainbody_right').load("check/checkForm.do",{vistid:vistid,userId:userId,userName:userName});
	     }); 
 }
 
 function diagnose(){
	 
			 $.ajax({
					type : "POST",
					url : "register/diagnose.do",
					async:false,
					data : {
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
						}else{
							alert('获取失败');
						}  
					},
					error : function() {
						alert("error");
					}
				});
	
};

//医生诊断列表
function findDiagnose(){
	 $(".query").find('.find').click(function(){
		 var vistId =  $('.vistId').val();
		 var userName =  $('.userName').val();
		 //还原偏移量
		 offset = 0;
		 page = 0;
		 if(vistId != '' && userName == '')
		 {
			 flag = 1;
		 }else if(userName != '' && vistId == ''){
			 flag = 2;
		 }else if(vistId != '' && userName != ''){
			 flag = 1;
		 }else{
			 flag = 0;
		 }
		 $.ajax({
				type : "POST",
				url : "register/findRegisterByVistId.do",
				async:false,
				data : {
					'vistId':vistId,
					'userName':userName,
					'flag':flag,
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
						$('.vistId').attr('data-vistId',vistId);
						$('.userName').attr('data-name',userName);
						 bindEvent();
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
	     });
}
 
 