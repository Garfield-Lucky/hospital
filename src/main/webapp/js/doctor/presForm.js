 var offset = 0;//控制偏移多少条数据
 var dataNum=0 ;//记录数据库返回的数据总数
 var page = 0;
 var pageSize = 5;
 
$(function(){
	 $(".query").find('.addPress').click(function(){
		     var vistId = $(this).attr('data-id');
			 var medicinName = $('.medicinName').val();
			 var medicineSpec = $('.medicineSpec').val();
			 var remark = $('.remark').val();
			 var count = $('.number').val();
			 
			if(medicinName != '' && medicineSpec != '' && count != '')
			{
				var check = false;
				$.ajax({
					type : "POST",
					url : "medicine/findMedicineByNameAndSpec.do",
					async:false,
					data : {
						'name':medicinName,
						'spec':medicineSpec
					},
					dataType : 'json',
					success : function(data) {
						if (data.status == "0000") {
							check = true;
						}else{
							check = false;
						}  
					},
					error : function() {
						alert("error");
					}
				});
				
			if(check == true)	
			{
			 $.ajax({
					type: "POST",
					url: 'pres/add.do',
					data: {
						'vistId':vistId,
						'medicinName':medicinName,
						'medicineSpec':medicineSpec,
						'count':count,
						'remark':remark,
						'status':0,
						'page':page,
						'pageSize':pageSize
					},
					dataType:'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#pres_list').html(departmentList4(data.list));
							dataNum = data.dataNum;
							if(dataNum != 0)
							{
							   $('.pagePosition').show();
							}else{
								  $('.pagePosition').hide();
							}
							$('#currentPage').html(data.currentPage);
							$('#countPage').html(data.countPage);
							 $('.medicinName').val('');
							 $('.medicineSpec').val('');
							 $('.remark').val('');
							 $('.number').val('');
							deletePres();
						}else{
							 alert('获取失败');
						      }  
							},
						error : function() {
							alert("异常");
							}
						});
		    	}else{
		    		alert('药品不存在');
		    	}
			}else{
				alert('添加信息有误');
			 }
		     });
	 
	 medicineList();//默认加载一部分药品出来
	 PresList();
	 
	 $('#medicineList').on("click","a",function(){
		 var value = $(this).attr('data-id');
		 $('.medicinName').val(value);
		 medicineSpec();
	 });
	 $('#specList').on("click","a",function(){
		 var value = $(this).attr('data-id');
		 $('.medicineSpec').val(value);
	 });
	 
	 $('.medicineSpec').on("click",function(){
		 medicineSpec();
	 });
	 //模糊查询
	 $('.medicinName').keyup(function() {
		 var medicinName = $('.medicinName').val();
		 if(medicinName.trim() != '')
		 {
			$.ajax({
				type : "POST",
				url : "medicine/findMedicineName.do",
				async:false,
				data : {
					'name':medicinName
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						for(var i=0;i<data.list.length;i++)
							{
							    var value = data.list[i].medicineName;
							    $('#medicineList').html('');
							    $('#medicineList').append('<li><a class="itemName" data-id='+value+'>'+value+'</a></li>');
							}
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
		 }else{
			 
		 }
		});
	 
	 
	 //首页
	 $("#session").on("click", "#firstPage",  function() {
		    pageA(0,0);
		    var vistId = $('.addPress').attr('data-id');
		    $.ajax({
				type : "POST",
				url : "pres/getAddPresList.do",
				async:false,
				data : {
					'vistId':vistId,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#pres_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deletePres();
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
		    var vistId = $('.addPress').attr('data-id');
		    $.ajax({
				type : "POST",
				url : "pres/getAddPresList.do",
				async:false,
				data : {
					'vistId':vistId,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#pres_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deletePres();
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
		 var vistId = $('.addPress').attr('data-id');
		    $.ajax({
				type : "POST",
				url : "pres/getAddPresList.do",
				async:false,
				data : {
					'vistId':vistId,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#pres_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deletePres();
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
		    var vistId = $('.addPress').attr('data-id');
		    $.ajax({
				type : "POST",
				url : "pres/getAddPresList.do",
				async:false,
				data : {
					'vistId':vistId,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#pres_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deletePres();
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
		    var vistId = $('.addPress').attr('data-id');
		    $.ajax({
				type : "POST",
				url : "pres/getAddPresList.do",
				async:false,
				data : {
					'vistId':vistId,
					'page':page,
					'pageSize':pageSize
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#pres_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deletePres();
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

function medicineList() {
		$.ajax({
			type : "POST",
			url : "medicine/getMedicineList.do",
			async:false,
			data : {
				'page':0,
				'pageSize':100
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					for(var i=0;i<data.list.length;i++)
					{
					    var value = data.list[i].medicineName;
					    $('#medicineList').append('<li><a class="itemName" data-id='+value+'>'+value+'</a></li>');
					}
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
		
	}

 function PresList() {
	  var vistId = $('.addPress').attr('data-id');
		$.ajax({
			type : "POST",
			url : "pres/getAddPresList.do",
			async:false,
			data : {
				'page':page,
				'pageSize':pageSize,
				'vistId':vistId
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					$('#pres_list').html(departmentList4(data.list));
					dataNum = data.dataNum;
					if(dataNum != 0)
					{
					   $('.pagePosition').show();
					}else{
						  $('.pagePosition').hide();
					}
					$('#currentPage').html(data.currentPage);
					$('#countPage').html(data.countPage);
					deletePres();
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
		
	}

function deletePres() {
		//删除处方单
		$(".del").on("click",function() {
			var id = $(this).attr('data-id');
			var vistId = $(this).attr('data-vistId');
			var b = window.confirm('你确定要删除该药品吗？');
			if(b)
			{
			$.ajax({
				url:"pres/del.do",//指定路径
				dataType:"json",
				type:"POST",
				data:{
					"id":id,
					'vistId':vistId,
					'page':page,
					'pageSize':pageSize
				},cache:false,
				success:function(data){	
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					if(data.status=="0000"){
						$('#pres_list').html(departmentList4(data.list));
						dataNum = data.dataNum;
						if(dataNum != 0)
						{
						   $('.pagePosition').show();
						}else{
							  $('.pagePosition').hide();
						}
						$('#currentPage').html(data.currentPage);
						$('#countPage').html(data.countPage);
						deletePres();
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
//规格列表
function medicineSpec() {
	 var medicinName = $('.medicinName').val();
	 if(medicinName.trim() != '')
	 {
		$.ajax({
			type : "POST",
			url : "medicine/findMedicineSpec.do",
			async:false,
			data : {
				'name':medicinName
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					for(var i=0;i<data.list.length;i++)
						{
						    var value = data.list[i].medicineSpec;
						    $('#specList').html('');
						    $('#specList').append('<li><a class="itemName" data-id='+value+'>'+value+'</a></li>');
						}
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
	 }else{
		 
	 }
	};