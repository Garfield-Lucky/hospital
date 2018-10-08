 $(function(){
	 $(".addDoctorWork1").on('click',function(){
		 var doctorCode = $('.doctorCode').val();
		 var registerCount = $('.registerCount').val();
		 var workDate = $('.workDate').val();
		 var workTime = $('.workTime').val();
	 if(doctorCode != '' && workDate != '' && registerCount != '' && workTime != '')
		 {
		 $.ajax({
				type: "POST",
				url: 'doctorWork/add.do',
				data: {
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
						alert('添加成功');
						$('.doctorCode').val('');
						$('.registerCount').val('');
						$('.workDate').val('');
						$('.workTime').val('');
					  //  $('.mainbody_right').load("pages/doctorWorkManager.jsp");
					}else{
						 alert('添加失败')
							}
						},
					error : function() {
						alert("异常");
						}
					});
		 }else{
			 alert('信息不完整，无法添加');
		 }
	     });
	 
 })
