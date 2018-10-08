 $(function(){
	 $('.save').click(function(){
	        var passwordOld = $('.passwordOld').val();
	        var passwordNew1 = $('.passwordNew1').val();
	        var passwordNew2 = $('.passwordNew2').val();
	        if(passwordOld == '' || passwordNew1 == '' || passwordNew2 == '') {
	           
	            return false;
	        }
	        if(passwordNew1 != passwordNew2) {
	        	alert('两次密码不一致');
	        	return false;
	        }
	        if(passwordNew1.length > 5) {
	            $.ajax({
	    			type: "POST",
	    			url: 'user/mod.do',
	    			data: {
	    				'password':passwordNew1,
	    				'passwordOld':passwordOld
	    			},
	    			dataType:'json',
	    			success : function(data) {
	    				if(data.flag){
	    					alert(data.msg); 
	    				}else{
	    					alert(data.msg); 
	    				} 
	    			 },
    				error : function() {
    					alert(data.msg);
    					}
    				});
	        }else{
	        	alert('密码长度不能小于5');
	        }
	    });
    
 });