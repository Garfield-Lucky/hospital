 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var flag = 0;
 var page = 0;
 var pageSize = 5; 

$(function(){
	 $(".query").find('.find').click(function(){
		 var officeType =  $('.officeType').val();
		 var doctorName =  $('.doctorName').val();
		 //还原偏移量
		 offset = 0;
		 page = 0;
		 if(officeType != '' && doctorName == '')
		 {
			  flag = 1;
		 }else if(doctorName != '' && officeType == ''){
			 flag = 2;
		 }else if(doctorName != '' && officeType != ''){
			 flag = 3;
		 }else{
			 flag = 0;
		 }
		 $.ajax({
				type : "POST",
				url : "register/registerListByCondiction.do",
				async:false,
				data : {
					'officeType':officeType,
					'doctorName':doctorName,
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
						$('.officeType').attr('data-type',officeType);
						$('.doctorName').attr('data-name',doctorName);
						 liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
	     });
	 
	 bind();
	 
	 $(".table").on('click','.register',function(){
		 var doctorCode = $(this).attr('data-code');
		 var workDate = $(this).attr('data-date');
		 var officeCode = $(this).attr('data-office');
		  $(".registerPage").off('click').on('click','.ok',function(){
			 var userId = $('.userId').val();
			 var pay = $('input[name=payType]:checked').val();
			  
			 if(userId != '')
			 {
			 $.ajax({
					type: "POST",
					url: 'register/register.do',
					data: {
						'code':doctorCode,
						'officeCode':officeCode,
						'workDate':workDate,
						'userId':userId,
						'payType':pay
					},
					dataType:'json',
					success : function(data) {
						if(data.flag){
							$(".registerPage").hide();
							$(".mask").hide();
							$('.userId').val('');
							bind();
						}else{
								alert(data.msg);
							  }
							},
						error : function() {
							alert("预约异常");
							}
						});
			 }else{
				 alert('请输入用户id');
			 }
		    });
		  
		  $(".registerPage").find('.cancel').click(function(){
			  bind();
		  });
		  $(".registerPage").find('.close').click(function(){
			  bind();
		  })
	 });
	 
});	 
 
	 //首页
	 $("#session1").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var officeType =  $('.officeType').attr('data-type');
			var doctorName =  $('.doctorName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/registerListByCondiction.do",
				async:false,
				data : {
					'officeType':officeType,
					'doctorName':doctorName,
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
						liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
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
		    var officeType =  $('.officeType').attr('data-type');
			var doctorName =  $('.doctorName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/registerListByCondiction.do",
				async:false,
				data : {
					'officeType':officeType,
					'doctorName':doctorName,
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
						liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
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
		  var officeType =  $('.officeType').attr('data-type');
		  var doctorName =  $('.doctorName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/registerListByCondiction.do",
				async:false,
				data : {
					'officeType':officeType,
					'doctorName':doctorName,
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
						liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
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
		    var officeType =  $('.officeType').attr('data-type');
			var doctorName =  $('.doctorName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/registerListByCondiction.do",
				async:false,
				data : {
					'officeType':officeType,
					'doctorName':doctorName,
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
						liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
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
		    var officeType =  $('.officeType').attr('data-type');
			var doctorName =  $('.doctorName').attr('data-name');
		    $.ajax({
				type : "POST",
				url : "register/registerListByCondiction.do",
				async:false,
				data : {
					'officeType':officeType,
					'doctorName':doctorName,
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
						liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
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
 
 function registerList() {
	 
		$.ajax({
			type : "POST",
			url : "register/registerList.do",
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
		
	}
 function bind(){
	 registerList();
	 liClick.hoverLi($(".table")).alertShow($(".register"),$(".registerPage")).alertHide($(".close"),$(".registerPage"));
 }
