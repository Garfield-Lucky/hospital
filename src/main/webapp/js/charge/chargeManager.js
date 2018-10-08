 $(function(){
	  
	 $(".query").find('.jiesuan').click(function(){
		 var stime =  $('.stime').val();
		 var etime =  $('.etime').val();
		 if(stime != '' && etime != '')
		 {
		  $.ajax({
				type : "POST",
				url : "charge/clearing.do",//结算
				async:false,
				data : {
					'stime':stime,
					'etime':etime
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#chargeCount').html(departmentList4(data.list));
					}else{
						alert('获取失败');
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
 });