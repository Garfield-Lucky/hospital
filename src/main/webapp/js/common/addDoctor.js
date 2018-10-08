 $(function(){
	 $(".addDoctor").on('click',function(){
		 var doctorCode = $('.doctorCode').val();
		 var doctorName = $('.doctorName').val();
		 var sex = $('input[name=sex]:checked').val();
		 var age = $('.age').val();
		 if(age=='')
			 {
			   age=0;
			 }
		 var phone = $('.phone').val();
		 var title = $('.title').val();
		 var registerFee = $('.registerFee').val();
		 var clinicType = $('.clinicType').val();
		 var officeCode = $('.officeCode').val();
		 
		 $.ajax({
				type: "POST",
				url: 'doctor/add.do',
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
						alert('添加成功');
						$('.doctorCode').val('');
						$('.clinicType').val('');
						$('.officeCode').val('');
					  //  $('.mainbody_right').load("pages/doctorManager.jsp");
					}else{
						 alert('添加失败')
							}
						},
					error : function() {
						alert("异常");
						}
					});
	     });
	 
 })
