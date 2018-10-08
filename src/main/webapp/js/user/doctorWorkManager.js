 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var flag = 0;
 var page = 0;
 var pageSize = 5; 

$(function(){
	  
	 $(".query").find('.find').click(function(){
		 var doctorCode =  $('.doctorCode').val();
		 var registerCount =  $('.registerCount').val();
		 var workDate =  $('.workDate').val();
		 var workTime =  $('.workTime').val();
		 //还原偏移量
		 offset = 0;
		 page = 0;
		 if(doctorCode != '' && registerCount == '' && workDate == '' && workTime == '')
		 {
			 flag = 1;
		 }else if(doctorCode == '' && registerCount != '' && workDate == '' && workTime == ''){
			 flag = 2;
		 }else if(doctorCode == '' && registerCount == '' && workDate != '' && workTime == ''){
			 flag = 3;
		 }else if(doctorCode == '' && registerCount == '' && workDate == '' && workTime != ''){
			 flag = 4;
		 }else if(doctorCode == '' && registerCount != '' && workDate != '' && workTime == ''){
			 flag = pageSize;
		 }else if(doctorCode == '' && registerCount != '' && workDate == '' && workTime != ''){
			 flag = 6;
		 }else if(doctorCode == '' && registerCount == '' && workDate != '' && workTime != ''){
			 flag = 7;
		 }else if(doctorCode != '' && registerCount != '' && workDate == '' && workTime == ''){
			 flag = 8;
		 }else if(doctorCode != '' && registerCount == '' && workDate != '' && workTime == ''){
			 flag = 9; 
		 }else if(doctorCode != '' && registerCount == '' && workDate == '' && workTime != ''){
			 flag = 10; 
		 }else if(doctorCode != '' && registerCount != '' && workDate != '' && workTime == ''){
			 flag = 11; 
		 }else if(doctorCode != '' && registerCount != '' && workDate == '' && workTime != ''){
			 flag = 12; 
		 }else if(doctorCode != '' && registerCount == '' && workDate != '' && workTime != ''){
			 flag = 13; 
		 }else if(doctorCode == '' && registerCount != '' && workDate != '' && workTime != ''){
			 flag = 14; 
		 }else if(doctorCode != '' && registerCount != '' && workDate != '' && workTime != ''){
			 flag = 15; 
		 }else {
			 flag = 0; 
		 }
		 $.ajax({
				type : "POST",
				url : "doctorWork/find.do",
				async:false,
				data : {
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						$('.doctorCode').attr('data-code',doctorCode);
						$('.registerCount').attr('data-count',registerCount);
						$('.workDate').attr('data-date',workDate);
						$('.workTime').attr('data-time',workTime);
						deleteDoctorWork();
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
	     });
	 $(".query").find('.add').click(function(){
 		 $('.mainbody_right').load("pages/addDoctorWorkInfo.jsp");
 	     });
	 $("#session").on('click','.update',function(){
		 var id = $(this).attr('data-id');
 		 $('.mainbody_right').load("doctorWork/detail.do",{id:id});
 	     });
	 
	 doctorWorkList();
	 
	 //首页
	 $("#session").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var doctorCode =  $('.doctorCode').attr('data-code');
			var registerCount =  $('.registerCount').attr('data-count');
			var workDate =  $('.workDate').attr('data-date');
			var workTime =  $('.workTime').attr('data-time');
		    $.ajax({
				type : "POST",
				url : "doctorWork/find.do",
				async:false,
				data : {
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deleteDoctorWork();
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
		    var doctorCode =  $('.doctorCode').attr('data-code');
			var registerCount =  $('.registerCount').attr('data-count');
			var workDate =  $('.workDate').attr('data-date');
			var workTime =  $('.workTime').attr('data-time');
		    $.ajax({
				type : "POST",
				url : "doctorWork/find.do",
				async:false,
				data : {
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deleteDoctorWork();
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
		 var doctorCode =  $('.doctorCode').attr('data-code');
		 var registerCount =  $('.registerCount').attr('data-count');
		 var workDate =  $('.workDate').attr('data-date');
		 var workTime =  $('.workTime').attr('data-time');
		    $.ajax({
				type : "POST",
				url : "doctorWork/find.do",
				async:false,
				data : {
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deleteDoctorWork();
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
		    var doctorCode =  $('.doctorCode').attr('data-code');
			var registerCount =  $('.registerCount').attr('data-count');
			var workDate =  $('.workDate').attr('data-date');
			var workTime =  $('.workTime').attr('data-time');
		    $.ajax({
				type : "POST",
				url : "doctorWork/find.do",
				async:false,
				data : {
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deleteDoctorWork();
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
		    var doctorCode =  $('.doctorCode').attr('data-code');
			var registerCount =  $('.registerCount').attr('data-count');
			var workDate =  $('.workDate').attr('data-date');
			var workTime =  $('.workTime').attr('data-time');
		    $.ajax({
				type : "POST",
				url : "doctorWork/find.do",
				async:false,
				data : {
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deleteDoctorWork();
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
 
 function doctorWorkList() {
		
		$.ajax({
			type : "POST",
			url : "doctorWork/getDoctorWorkList.do",
			async:false,
			data : {
				'page':page,
				'pageSize':pageSize
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					$('#doctorWork_list').html(departmentList4(data.list));
					dataNum = data.dataNum;
					if(dataNum != 0)
					{
					   $('.pagePosition').show();
					}else{
						  $('.pagePosition').hide();
					}
					$('#currentPage').html(data.currentPage);
					$('#countPage').html(data.countPage);
					deleteDoctorWork();
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
		
	}

function deleteDoctorWork() {
		//删除安排日程
	    var doctorCode =  $('.doctorCode').attr('data-code');
		var registerCount =  $('.registerCount').attr('data-count');
		var workDate =  $('.workDate').attr('data-date');
		var workTime =  $('.workTime').attr('data-time');
		$(".del").on("click",function() {
			var id = $(this).attr('data-id');
			var b = window.confirm('你确定要删除该安排日程吗？');
			if(b)
			{
			$.ajax({
				url:"doctorWork/del.do",//指定路径
				dataType:"json",
				type:"POST",
				data:{
					'id':id,
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'workDate':workDate,
					'workTime':workTime,
					'flag':flag,
					'page':page,
					'pageSize':pageSize
				},cache:false,
				success:function(data){	
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					if(data.status=="0000"){
						$('#doctorWork_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deleteDoctorWork();
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