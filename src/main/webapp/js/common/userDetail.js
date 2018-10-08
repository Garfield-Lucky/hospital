 $(function(){
	 $(".mod_user").on('click',function(){
		 var workNum = $('.workNum').val();
		 var userName = $('.userName').val();
		 var userType = $('.userType').val();
		 if(workNum != '' && userName != '' && userType !='')
		 {
		 $.ajax({
				type: "POST",
				url: 'user/modUser.do',
				data: {
					'userName':workNum,
					'trueName':userName,
					'userType':userType,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert(data.msg);
					 $('.mainbody_right').load("pages/userManager.jsp");
					}else{
						 alert(data.msg)
							}
						},
					error : function() {
						alert("异常");
						}
					});
		 }else{
			 alert('输入不能为空');
		 }
	     });
	
 })
