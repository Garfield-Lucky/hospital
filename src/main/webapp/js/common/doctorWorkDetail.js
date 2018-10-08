 $(function(){
	 $(".mod_doctorWork").on('click',function(){
		 var id            =  $('.mod_doctorWork').attr('data-id');
		 var doctorCode    =  $('.doctorCode').val();
		 var registerCount =  $('.registerCount').val();
		 var workDate      =  $('.workDate').val();
		 var workTime      =  $('.workTime').val();
		 $.ajax({
				type: "POST",
				url: 'doctorWork/mod.do',
				data: {
					'id':id,
					'doctorCode':doctorCode,
					'registerCount':registerCount,
					'reaminCount':registerCount,
					'date':workDate,
					'workTime':workTime,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('修改成功');
						 $('.mainbody_right').load("pages/doctorWorkManager.jsp");
						//window.location.href="filter/home.do";
					}else{
						 alert('修改失败')
							}
						},
					error : function() {
						alert("修改异常");
						}
					});
 	     });
	 
 })
