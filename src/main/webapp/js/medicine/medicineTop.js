 var offset = 0;//控制偏移多少条数据
 var flag = 0;
 var page = 0;
 var pageSize = 5;

$(function(){
	 $('#main_top').hide();//首先隐藏echarts图的展示
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
				url : "medicine/getSaleTop.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#top_list').html(departmentList4(data.list));
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
						
						showEcharts(data.data);
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
		  
	     });
	 
	 $(".query").on('click','.change',function(){
		 var id = parseInt($('.change').attr('data-id'));
			 if(id%2 == 0)
			 {
			   $('.table').hide();
			   $('.pagePosition').hide();
			   $('#main_top').show();
			 }else{
			   $('#main_top').hide();
		  	   $('.table').show();
		  	  $('.pagePosition').show();
			 }
			 $('.change').attr('data-id',id+1);
 	     });
	 
	 
	//首页
	 $("#session1").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "medicine/getSaleTop.do",
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
						$('#top_list').html(departmentList4(data.list));
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
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "medicine/getSaleTop.do",
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
						$('#top_list').html(departmentList4(data.list));
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
		 var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "medicine/getSaleTop.do",
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
						$('#top_list').html(departmentList4(data.list));
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
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "medicine/getSaleTop.do",
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
						$('#top_list').html(departmentList4(data.list));
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
		    var stime = $('.stime').attr('data-stime');
		    var etime = $('.etime').attr('data-etime');
		    $.ajax({
				type : "POST",
				url : "medicine/getSaleTop.do",
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
						$('#top_list').html(departmentList4(data.list));
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

function showEcharts(data){
	   var myChart = echarts.init(document.getElementById('main_top'));

	     // 绘制图表
	   myChart.setOption({
	         title: {
	             text: '药品销量排行'
	         },
	         tooltip: {},
	         legend: {
	             data:['销量']
	         },
	         xAxis: {
	             data: []
	         },
	         yAxis: {},
	         series: [{
	             name: '销量',
	             type: 'bar',
	             data: data
	         }]
	     });
	 }
 