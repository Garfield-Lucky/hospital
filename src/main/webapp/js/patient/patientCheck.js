 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var flag = 0;
 var page = 0;
 var pageSize = 5;
 
$(function(){
	 $(".query").find('.find').click(function(){
		 var stime =  $('.stime').val();
		 var etime =  $('.etime').val();
		 //还原偏移量
		 offset = 0;
		 page = 0;
		 if(stime != '' && etime != '')
		 {
			  flag = 1;
		 }else{
			 flag = 0;
		 }
		 $.ajax({
				type : "POST",
				url : "check/findByUser.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
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
						$('.stime').attr('data-stime',stime);
						$('.etime').attr('data-etime',etime);
						deleteCheck();
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
	     });
 
	 $("#session1").on('click','.update',function(){
		 var doctorCode = $(this).attr('data-id');
 		 $('.mainbody_right').load("check/detail.do",{doctorCode:doctorCode});
 	     });
	 $("#session1").on('click','.see',function(){
		 var result = $(this).attr('data-content');
		 var userId = $(this).attr('data-userId');
		 var userName = $(this).attr('data-userName');
		 var status = $(this).attr('data-status');
		 var checkPhoto = $(this).attr('data-photo');
		 if(status == "未检查")
			 {
			     alert('未检查，无法查看！');
			     return ;
			 }
 		 $('.mainbody_right').load("check/showCheckResult.do",{result:result,photo:checkPhoto,userId:userId,userName:userName});
 	     });
	 
	 checkList();
	 
	 //首页
	 $("#session1").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "check/findByUser.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
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
						deleteCheck();
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
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "check/findByUser.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
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
						deleteCheck();
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
		  var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "check/findByUser.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
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
						deleteCheck();
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
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "pres/findByUser.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
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
						deleteCheck();
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
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "check/findByUser.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
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
						deleteCheck();
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
			url : "check/findByUser.do",
			async:false,
			data : {
				'page':page,
				'pageSize':pageSize,
				'flag':flag
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
					deleteCheck();
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
		
	}

function deleteCheck() {
		//删除处方单
		$(".del").on("click",function() {
			var id = $(this).attr('data-id');
			var vistId = $(this).attr('data-vistId');
			var b = window.confirm('你确定要删除该检查单吗？');
			if(b)
			{
			$.ajax({
				url:"check/delCheck.do",//指定路径
				dataType:"json",
				type:"POST",
				data:{
					'id':id,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},cache:false,
				success:function(data){	
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					if(data.status=="0000"){
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
						deleteCheck();
					}else{
						alert('删除失败');
					}
					
				},error : function(data) {
					alert('删除异常')
				}
			});	
		  }
		})
	}