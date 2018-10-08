 $(function(){
	 
	 $(".nav").find('.login').click(function(){
	 	  
		 window.location.href="login.jsp";
 	});
	 $(".nav").find('.logout').click(function(){
	 	  
		 window.location.href="filter/logout.do";
		 window.location.href="login.jsp";
 	});
    $(".mainbody").find('.register_info').click(function(){
 	  
    	 sessionCheck("pages/registerInfo.jsp");
 	});
      //预约挂号
      $(".mainbody").find('.register_apply').click(function(){

    	  sessionCheck("pages/registerApply.jsp");
   	});
      //退号管理
      $(".mainbody").find('.backRegister').click(function(){
     	  
  		sessionCheck("pages/registerBack.jsp");
  	});
      //挂号统计
      $(".mainbody").find('.count').click(function(){
     	  
  		sessionCheck("pages/registerCount.jsp");
  	});
      //诊断管理
      $(".mainbody").find('.zhenduan').click(function(){
     	  
   		sessionCheck("pages/diagnose.jsp");
   	});
      //病人列表
      $(".mainbody").find('.patient_list').click(function(){
     	  
    		 sessionCheck("pages/patientList.jsp");
    	});
 
    //检查单管理  
      $(".mainbody").find('.check').click(function(){
     	  
 		sessionCheck("pages/checkManager.jsp");
 	});
   //处方单管理 
     $(".mainbody").find('.chufang').click(function(){
     	  
 		sessionCheck("pages/presManager.jsp");
 	});
     //诊断单管理 
     $(".mainbody").find('.diagnoseManager').click(function(){
     	  
 		sessionCheck("pages/diagnoseManager.jsp");
 	});
   //划价收费
   $(".mainbody").find('.charge').click(function(){
     	  
 		sessionCheck("pages/charge.jsp");
 	});
   //收费结算
    $(".mainbody").find('.chargeAccount').click(function(){
     	  
 		sessionCheck("pages/chargeManager.jsp");
 	});
   //账单管理 
    $(".mainbody").find('.billManager').click(function(){
     	  
 		sessionCheck("pages/billManager.jsp");
 	});
    //充值中心
    $(".mainbody").find('.voucherCenter').click(function(){
     	  
 		sessionCheck("pages/voucherCenter.jsp");
 	});
    //统计汇总
    $(".mainbody").find('.countGather').click(function(){
     	  
 		sessionCheck("pages/countManager.jsp");
 	});
    
    //检查室患者列表
    $(".mainbody").find('.checkList').click(function(){
     	  
 		sessionCheck("pages/checkListShow.jsp");
 	});
  //检查结果单管理
    $(".mainbody").find('.checkResultManager').click(function(){
   	  
		 sessionCheck("pages/checkResultManager.jsp");
	});
    
    //摆药
    $(".mainbody").find('.baiyao').click(function(){
     	  
 		sessionCheck("pages/medicineSale.jsp");
 	});
    
  //入库管理
    $(".mainbody").find('.import').click(function(){
     	  
 		sessionCheck("pages/medicineImport.jsp");
 	});
    //药品管理
    $(".mainbody").find('.medicineManager').click(function(){
     	  
 		sessionCheck("pages/medicineManager.jsp");
 	});
    //销售排行
    $(".mainbody").find('.saleTop').click(function(){
     	  
 		sessionCheck("pages/medicineTop.jsp");
 	});
    //患者信息列表
    $(".mainbody").find('.patientList').click(function(){
     	  
 		sessionCheck("pages/patientManager.jsp");
 	});
    //医生信息列表
    $(".mainbody").find('.doctorList').click(function(){
     	  
 		sessionCheck("pages/doctorManager.jsp");
 	});
    //医生值班安排管理
    $(".mainbody").find('.doctorWork').click(function(){
     	  
 		sessionCheck("pages/doctorWorkManager.jsp");
 	});
    //检查检验费用管理
    $(".mainbody").find('.checkFee').click(function(){
     	  
 		sessionCheck("pages/checkFeeManager.jsp");
 	});
    //科室管理
    $(".mainbody").find('.officeManager').click(function(){
     	  
 		sessionCheck("pages/officeManager.jsp");
 	});
    //账户管理
    $(".mainbody").find('.accountManager').click(function(){
 		
 		sessionCheck("pages/accountManager.jsp");
 	});
    //个人信息
    $(".mainbody").find('.personInfo').click(function(){
    	 
    	 sessionCheck("patient/userInfo.do");
	});
	
    //用户管理
    $(".mainbody").find('.userManager').click(function(){
 		
 		sessionCheck("pages/userManager.jsp");
 	});
    
    //病历单查询
    $(".mainbody").find('.findDiagnose').click(function(){
		 
		 sessionCheck("pages/patientDiagnoseForm.jsp");
	});
    //处方单查询
    $(".mainbody").find('.findPres').click(function(){
		
		 sessionCheck("pages/patientPressForm.jsp");
	});
    //检查单查询
    $(".mainbody").find('.findCheck').click(function(){
		 
		 sessionCheck("pages/patientCheckForm.jsp");
	});
    //在线预约挂号
    $(".mainbody").find('.registerInline').click(function(){
    	
		 sessionCheck("pages/patientRegister.jsp");
	});
    
    
 });
 
 function sessionCheck(path){
	 $.ajax({
			type : "POST",
			url : "filter/sessionCheck.do",
			async:false,
			data : {
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					$('.mainbody_right').load(path);
				}else{
					window.location.href="login.jsp";
				}  
			},
			error : function() {
				alert("error");
			}
		});
 }