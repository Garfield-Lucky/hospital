 $(function(){
	 $(".query").find('.updateDiagnose').click(function(){
		 var vistId = $(this).attr('data-id');
		 var diagnose = $('.diagnose').val();
		 if(diagnose != '' && vistId != '')
		 {
		  $.ajax({
				type : "POST",
				url : "doctor/updateDiagnose.do",
				async:false,
				data : {
					'diagnose':diagnose,
					'vistId':vistId
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						alert(data.msg);
					}else{
						alert(data.msg);
					}  
				},
				error : function() {
					alert("error");
				}
			});
		 }else{
			alert('诊断结果不能为空');
		 }
	 });
 })

 