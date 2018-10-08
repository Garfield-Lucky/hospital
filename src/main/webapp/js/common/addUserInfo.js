 $(function(){
	 $(".addUser").on('click',function(){
		 var workNum = $('.workNum').val();
		 var userName = $('.UserName').val();
		 var userType = $('.userType').val();
		 if(workNum != '' && userName != '' && userType !='')
		 {
		 $.ajax({
				type: "POST",
				url: 'user/add.do',
				data: {
					'userName':workNum,
					'trueName':userName,
					'passWord':123456,
					'userType':userType,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert(data.msg);
						$('.workNum').val('');
						$('.UserName').val('');
						$('.userType').val('');
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
