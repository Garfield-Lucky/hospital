
$(function(){
	$(".voucher").find('.save').click(function(){
		 var userId =  $('.userid').val();
		 var money =  $('.money').val();
		 var reg = /^[\d]+$/g;
		 
		 if(!reg.test(money))
		 {
			 alert('请输入数字！');
			 $('.money').focus();
			 return;
		 }
		 if(userId != '' && money !='')
		{
		 $.ajax({
				type : "POST",
				url : "charge/voucherCenter.do",
				async:false,
				data : {
					'userId':userId,
					'money':money
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						alert('充值成功');
						$('.userid').val('');
						$('.money').val('');
					}else{
						alert('充值失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
		}else{
			alert('输入不能为空');
		}
	});
})