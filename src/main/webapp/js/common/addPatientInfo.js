 $(function(){
	 $(".addUser").on('click',function(){
		 var userId = $('.idCard').val();
		 var UserName = $('.UserName').val();
		 var sex = $('input[name=sex]:checked').val();
		 var age = $('.age').val();
		 if(age=='')
			 {
			  age=0;
			 }
		 var medicalNum = $('.medicalNum').val();
		 var nation = $('.nation').val();
		 var address = $('.address').val();
		 var phone = $('.phone').val();
		 var idCard = $('.idCard').val();
		 var marry = $('input[name=marry]:checked').val();
		 var remark = $('.remark').val();
		 
		 $.ajax({
				type: "POST",
				url: 'patient/add.do',
				data: {
					'userId':userId,
					'UserName':UserName,
					'sex':sex,
					'age':age,
					'medicalNum':medicalNum,
					'nation':nation,
					'address':address,	
					'phone':phone,
					'idCard':idCard,
					'marry':marry,
					'remark':remark
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
//						alert('添加成功');
						$('.mainbody_right').load("pages/registerApply.jsp");
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
