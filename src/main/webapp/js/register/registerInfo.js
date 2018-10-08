 $(function(){
	  
	 $(".query").find('.find').click(function(){
		 var userId =  $('.userId').val();
		 $.ajax({
				type : "POST",
				url : "patient/findByRegister.do",
				async:false,
				data : {
					'userId':userId,
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#user_list').html(departmentList4(data.list));
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
 		 $('.mainbody_right').load("pages/addPatientInfo.jsp");
 	     });
	 
 });