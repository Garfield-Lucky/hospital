 $(function(){
	 $(".addOffice").on('click',function(){
		 var officeCode = $('.officeCode').val();
		 var officeType = $('.officeType').val();
		 var address = $('.address').val();
		 
		 $.ajax({
				type: "POST",
				url: 'office/add.do',
				data: {
					'officeCode':officeCode,
					'officeType':officeType,
					'address':address,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('添加成功');
						$('.officeCode').val('');
						$('.officeType').val('');
						$('.address').val('');
					 //   $('.mainbody_right').load("pages/officeManager.jsp");
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
