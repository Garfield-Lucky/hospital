 $(function(){
	 $(".query").find('.addDiagnose').click(function(){
		     var vistId = $(this).attr('data-id');
			 var diagnose = $('.result').val();
			if(diagnose != '')
			{
			 $.ajax({
					type: "POST",
					url: 'register/WriteDiagnose.do',
					data: {
						'vistId':vistId,
						'diagnose':diagnose
					},
					dataType:'json',
					success : function(data) {
						if (data.status == "0000") {
							var departmentList4 = Handlebars.compile($("#departmentList4").html());
							$('#diagnose_list').html(departmentList4(data.list));
						}else{
							 alert('获取失败');
						      }  
							},
						error : function() {
							alert("异常");
							}
						});
			}else{
				alert('诊断结果不能为空');
			 }
		 });
	 
	 
	 diagnoseList();
	 
 });
 
 function diagnoseList() {
	  var vistId = $('.addDiagnose').attr('data-id');
		$.ajax({
			type : "POST",
			url : "register/findDiagnose.do",
			async:false,
			data : {
				'vistId':vistId,
				'code':'D1003'
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					$('#diagnose_list').html(departmentList4(data.list));
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
		
	}
 