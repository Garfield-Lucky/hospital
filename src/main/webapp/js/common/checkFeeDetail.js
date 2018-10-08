 $(function(){
	 $(".mod_checkFee").on('click',function(){
		 var checkCode =  $('.checkCode').val();
		 var checkItem =  $('.checkItem').val();
		 var expend    =  $('.expend').val();
		 
		 $.ajax({
				type: "POST",
				url: 'checkFee/mod.do',
				data: {
					'checkCode':checkCode,
					'checkItem':checkItem,
					'expend':expend,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('修改成功');
						 $('.mainbody_right').load("pages/checkFeeManager.jsp");
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
