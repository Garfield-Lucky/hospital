 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var flag = 0;
 var page = 0;
 var pageSize = 5;

$(function(){
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
		 }else if(userName != '' && vistId != ''){
			 flag = 3;
		 }else{
			 flag = 0;
		 }
		 $.ajax({
				type : "POST",
				url : "check/findByCheckRoom.do",
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
						$('#check_list').html(departmentList4(data.list));
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
						$('.userName').attr('data-userName',userName);
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
	     });
 
	 $("#session1").on('click','.check',function(){
		 var id = $(this).attr('data-id');
		 var userId = $(this).attr('data-userId');
		 var userName = $(this).attr('data-userName');
 		 $('.mainbody_right').load("check/showCheckForm.do",{id:id,userId:userId,userName:userName});
 	     });
	 
	 checkList();
	 
	//首页
	 $("#session1").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var vistId = $('.vistId').attr('data-vistId');
		    var userName = $('.userName').attr('data-userName');
		    $.ajax({
				type : "POST",
				url : "check/findByCheckRoom.do",
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
						$('#check_list').html(departmentList4(data.list));
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
			 
		});
	 //上一页
	 $("#session1").on("click", "#prevPage",  function() {
		    pageA(2,0);
		    var vistId = $('.vistId').attr('data-vistId');
		    var userName = $('.userName').attr('data-userName');
		    $.ajax({
				type : "POST",
				url : "check/findByCheckRoom.do",
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
						$('#check_list').html(departmentList4(data.list));
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
			 
		});
	 //下一页
	 $("#session1").on("click", "#nextPage",  function() {
		    pageA(1,0);
		    var vistId = $('.vistId').attr('data-vistId');
		    var userName = $('.userName').attr('data-userName');
		    $.ajax({
				type : "POST",
				url : "check/findByCheckRoom.do",
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
						$('#check_list').html(departmentList4(data.list));
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
			 
		});
	 //尾页
	 $("#session1").on("click", "#trailPage",  function() {
		    pageA(3,0);
		    var vistId = $('.vistId').attr('data-vistId');
		    var userName = $('.userName').attr('data-userName');
		    $.ajax({
				type : "POST",
				url : "check/findByCheckRoom.do",
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
						$('#check_list').html(departmentList4(data.list));
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
			 
		});
	 //跳页
	 $("#session1").on("click", "#query",  function() {
		    var pageTo = $("#pageNum").val();
		    pageA(4,pageTo);
		    var vistId = $('.vistId').attr('data-vistId');
		    var userName = $('.userName').attr('data-userName');
		    $.ajax({
				type : "POST",
				url : "check/findByCheckRoom.do",
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
						$('#check_list').html(departmentList4(data.list));
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
 
 function checkList() {
		
		$.ajax({
			type : "POST",
			url : "check/getCheckListInCRoom.do",
			async:false,
			data : {
				'page':page,
				'pageSize':pageSize
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					$('#check_list').html(departmentList4(data.list));
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
		
	}

 