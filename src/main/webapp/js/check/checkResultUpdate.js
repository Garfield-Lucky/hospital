 $(function(){
	 
	 //jquery.form插件
	 $('#form1').ajaxForm({
		 beforeSerialize:function(){
			 var filepath = $('#photo').val();
		 },
		 success:function(data){
			 if (JSON.parse(data).status == "0000") {
					alert('更改成功');
					$('.mainbody_right').load("pages/checkResultManager.jsp");
				
			 }else{
					 alert('修改失败');
				     }  
		 }
	 });
	 $(".query").find('.updateCheckResult').click(function(){
		 $('#form1').submit();
	 });
	 
//	 $(".query").find('.updateCheckResult').click(function(){
//		 var id = $(this).attr('data-id');
//		 var checkResult = $('.checkContent').val();
//		 if(checkResult != '' && id != '')
//		 {
//		  $.ajax({
//				type : "POST",
//				url : "check/updateCheckResult.do",
//				async:false,
//				data : {
//					'checkResult':checkResult,
//					'id':id
//				},
//				dataType : 'json',
//				success : function(data) {
//					if (data.status == "0000") {
//						alert('更改成功');
//						$('.mainbody_right').load("pages/checkResultManager.jsp");
//					}else{
//						alert('更改失败');
//					}  
//				},
//				error : function() {
//					alert("error");
//				}
//			});
//		 }else{
//			alert('检查结果不能为空');
//		 }
//	 });
 })

 