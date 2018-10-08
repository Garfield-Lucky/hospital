 $(function(){
	 $(".addCheckFee").on('click',function(){
		 var checkCode = $('.checkCode').val();
		 var checkItem = $('.checkItem').val();
		 var expend = $('.expend').val();
		 
		 $.ajax({
				type: "POST",
				url: 'checkFee/add.do',
				data: {
					'checkCode':checkCode,
					'checkItem':checkItem,
					'expend':expend,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('添加成功');
						$('.checkCode').val('');
						$('.checkItem').val('');
					   // $('.mainbody_right').load("pages/checkFeeManager.jsp");
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
