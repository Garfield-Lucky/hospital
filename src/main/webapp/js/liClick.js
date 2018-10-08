var liClick = {
	hoverLi : function (obj){
		obj.find("modify").addClass("light");
	    obj.find("modify").click(function(){
	      obj.removeClass("light");
	      $(this).addClass("light");
	    })  
	    return this;
	  },
  alertShow : function(obj,a){
	  a.hide();
    obj.click(function(){
      a.show();
      $(".mask").show();
    })
    return this;
  },
  alertHide : function(obj,a){
    obj.click(function(){
     a.hide();
     $(".mask").hide();
    })
    $(".cancel").click(function(){
     a.hide();
     $(".mask").hide();
    })
    return this;
  }
}