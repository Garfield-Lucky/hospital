 $(function(){
	 
     //jquery.form插件
	 $('#form1').ajaxForm({
		 beforeSerialize:function(){
			 var filepath = $('#photo').val();
		 },
		 success:function(data){
			 if (JSON.parse(data).status == "0000") {
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					$('#check_list').html(departmentList4(JSON.parse(data).list));
				
			 }else{
					 alert('获取失败');
				     }  
		 }
	 });
	 $(".query").find('.addCheckResult').click(function(){
		 $('#form1').submit();
	 });
	 
	 checkList();
	 
 });
 
 function checkList() {
	  var id = $('.addCheckResult').attr('data-id');
		$.ajax({
			type : "POST",
			url : "check/findCheckResult.do",
			async:false,
			data : {
				'id':id
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					var departmentList4 = Handlebars.compile($("#departmentList4").html());
					$('#check_list').html(departmentList4(data.list));
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
		
	}
 