
jQuery(document).ready(function() {

    $('.login').click(function(){
        
    	login(); 
    });
    
    $(".page-container").keydown(function(event) {    
        if (event.keyCode == 13) {    
        	login();    
        }    
    })    
    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});

 function login(){
	 var username = $('.username').val();
     var password = $('.password').val();
     var autoLogin = false;
     if(username == '') {
         $('.error').fadeOut('fast', function(){
             $(this).css('top', '27px');
         });
         $('.error').fadeIn('fast', function(){
             $(this).parent().find('.username').focus();
         });
         return false;
     }
     if(password == '') {
         $('.error').fadeOut('fast', function(){
             $(this).css('top', '96px');
         });
         $('.error').fadeIn('fast', function(){
             $(this).parent().find('.password').focus();
         });
         return false;
     }
     if ($('.autoLogin').is(':checked')) {
			 
     	autoLogin = true;
		}
     
     if(username.trim() != '' && password.trim() != '')
     {
     $.ajax({
			type: "POST",
			url: 'login.do',
			data: {
				'userName':username,
				'passWord':password,
				'autoLogin':autoLogin				
			},
			dataType:'json',
			success : function(data) {
				if(data.flag){
					window.location.href="filter/home.do";
				}else{
					if(data.num=="0"){
						alert(data.msg);
						//$(".error").text("* "+data.msg).css({color:"red"});
					}else if(data.num=="1"){
						alert(data.msg);
						//$(".error").text("* "+data.msg).css({color:"red"});
					}else if(data.num=="2"){
						alert(data.msg);
						//$(".error").text("* "+data.msg).css({color:"red"});
							}
						}
					},
				error : function() {
					alert("登录失败");
					}
				});
     }
 }
 