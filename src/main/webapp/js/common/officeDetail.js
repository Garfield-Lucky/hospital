 $(function(){
	 $(".mod_office").on('click',function(){
		 var id =   $('.mod_office').attr('data-id');
		 var officeCode =  $('.officeCode').val();
		 var officeType =  $('.officeType').val();
		 var address =  $('.address').val();
		 $.ajax({
				type: "POST",
				url: 'office/mod.do',
				data: {
					'id':id,
					'officeCode':officeCode,
					'officeType':officeType,
					'address':address,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('修改成功');
						 $('.mainbody_right').load("pages/officeManager.jsp");
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
