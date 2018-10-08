 $(function(){
	 $(".mod_doctor").on('click',function(){
		 var doctorCode =  $('.doctorCode').val();
		 var doctorName =  $('.doctorName').val();
		 var sex =  $('input[name=sex]:checked').val();
		 var age =  $('.age').val();
		 var phone =  $('.phone').val();
		 var title =  $('.title').val();
		 var registerFee =  $('.registerFee').val();
		 var clinicType = $('.clinicType').val();
		 var officeCode =  $('.officeCode').val();
		 
		 $.ajax({
				type: "POST",
				url: 'doctor/mod.do',
				data: {
					'doctorCode':doctorCode,
					'doctorName':doctorName,
					'sex':sex,
					'age':age,
					'phone':phone,
					'title':title,
					'registerFee':registerFee,
					'clinicType':clinicType,
					'officeCode':officeCode,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('修改成功');
						 $('.mainbody_right').load("pages/doctorManager.jsp");
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
