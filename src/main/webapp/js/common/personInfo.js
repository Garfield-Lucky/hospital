 $(function(){
	 $(".mod_user").on('click',function(){
		 var userId =   $('.mod_user').attr('data-id');
		 var userName =  $('.userName').val();
		 var sex =  $('input[name=sex]:checked').val();
		 var age =  $('.age').val();
		 var marry =  $('input[name=marry]:checked').val();
		 var phone =  $('.phone').val();
		 var idCard =  $('.idCard').val();
		 var nation =  $('.nation').val();
		 var medicalNum =  $('.medicalNum').val();
		 var address =  $('.address').val();
		 var balanceMedical =  $('.balanceMedical').val();
		 var remark =  $('.remark').val();
		 
		 $.ajax({
				type: "POST",
				url: 'patient/mod.do',
				data: {
					'userId':userId,
					'userName':userName,
					'sex':sex,
					'age':age,
					'marry':marry,
					'phone':phone,
					'idCard':idCard,
					'nation':nation,
					'medicalNum':medicalNum,
					'address':address,
					'balanceMedical':balanceMedical,
					'remark':remark,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('修改成功');
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
