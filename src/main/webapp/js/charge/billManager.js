 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var flag = 0;
 var page = 0;
 var pageSize = 5;
 
$(function(){
	  
	 $(".query").find('.find').click(function(){
		 var stime =  $('.stime').val();
		 var etime =  $('.etime').val();
		 var vistId =  $('.vistId').val();
		 //还原偏移量
		 offset = 0;
		 page = 0;
		 if(stime != '' && etime != '' && vistId =='')
		 {
			 flag = 1;
		 }else if(vistId != '' && stime == '' && etime == ''){
			 flag = 2;
		 }else if(vistId != '' && stime != '' && etime != ''){
			 flag = 3;
		 }else{
			 flag = 0;
		 }
		 if(flag != 0)
		 {
		  $.ajax({
				type : "POST",
				url : "charge/billManager.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#bill_list').html(departmentList4(data.list));
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
						$('.vistId').attr('data-vistId',vistId);
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
		 }else{
			 alert('请输入查询条件');
		 }
	 });
	 
	 
	 //首页
	 $("#session").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var stime =  $('.stime').attr('data-stime');
		    var etime =  $('.etime').attr('data-etime');
		    var vistId =  $('.vistId').attr('data-vistId');
		    $.ajax({
				type : "POST",
				url : "charge/billManager.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#bill_list').html(departmentList4(data.list));
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
	 $("#session").on("click", "#prevPage",  function() {
		    pageA(2,0);
		    var stime =  $('.stime').attr('data-stime');
		    var etime =  $('.etime').attr('data-etime');
		    var vistId =  $('.vistId').attr('data-vistId');
		    $.ajax({
				type : "POST",
				url : "charge/billManager.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#bill_list').html(departmentList4(data.list));
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
	 $("#session").on("click", "#nextPage",  function() {
		 pageA(1,0);
		    var stime =  $('.stime').attr('data-stime');
		    var etime =  $('.etime').attr('data-etime');
		    var vistId =  $('.vistId').attr('data-vistId');
		    $.ajax({
				type : "POST",
				url : "charge/billManager.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#bill_list').html(departmentList4(data.list));
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
	 $("#session").on("click", "#trailPage",  function() {
		    pageA(3,0);
		    var stime =  $('.stime').attr('data-stime');
		    var etime =  $('.etime').attr('data-etime');
		    var vistId =  $('.vistId').attr('data-vistId');
		    $.ajax({
				type : "POST",
				url : "charge/billManager.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#bill_list').html(departmentList4(data.list));
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
	 $("#session").on("click", "#query",  function() {
		    var pageTo = $("#pageNum").val();
		    pageA(4,pageTo);
		    var stime =  $('.stime').attr('data-stime');
		    var etime =  $('.etime').attr('data-etime');
		    var vistId =  $('.vistId').attr('data-vistId');
		    $.ajax({
				type : "POST",
				url : "charge/billManager.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'vistId':vistId,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#bill_list').html(departmentList4(data.list));
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