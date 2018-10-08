
jQuery(document).ready(function() {

    $('.register').click(function(){
        var username = $('.username').val();
        var truename = $('.truename').val();
        var password = $('.password').val();
        if(username == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(truename == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.truename').focus();
            });
            return false;
        }
        if(password == '') {
            $('.error').fadeOut('fast', function(){
                $(this).css('top', '166px');
            });
            $('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        if(password.length > 5) {
            $.ajax({
    			type: "POST",
    			url: 'register.do',
    			data: {
    				'userName':username,
    				'trueName':truename,
    				'passWord':password
    			},
    			dataType:'json',
    			success : function(data) {
    				if(data.flag){
    					window.location.href="login.jsp";
    				}else{
    					if(data.num=="1"){
    						alert(data.msg);
    						//$(".error").text("* "+data.msg).css({color:"red"});
    					 }
    			   	  }
    			 },
    				error : function() {
    					alert("注册失败");
    					}
    				});
        }
    });

    $('.username').blur(function(){
        var username = $('.username').val();
    	$.ajax({
			type: "POST",
			url: 'registerCheck.do',
			data: {
				'userName':username
			},
			dataType:'json',
			success : function(data) {
				if(data.flag){
					
				}else{
					$('.error').fadeOut('fast', function(){
		                $(this).css('top', '27px');
		            });
		            $('.error').fadeIn('fast', function(){
		                $(this).parent().find('.username').focus();
		            });
			   	  }
			 },
				error : function() {
					alert("注册失败");
					}
				});
    });
    $('.page-container form .username, .page-container form .truename, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
