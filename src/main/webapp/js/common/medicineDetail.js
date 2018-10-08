 $(function(){
	 $(".mod_medicine").on('click',function(){
		 var medicineCode=  $('.mod_medicine').attr('data-id');
		 var billCode = $('.billCode').val();
		 var medicineName = $('.medicineName').val();
		 var purchaser = $('.purchaser').val();
		 var medicineSpec = $('.medicineSpec').val();
		 var tproDate = $('.tproDate').val();
		 var period = $('.period').val();
		 var probatchCode = $('.probatchCode').val();
		 var certiCode = $('.certiCode').val();
		 var approveCode = $('.approveCode').val();
		 var ckConclusion = $('.ckConclusion').val();
		 var repertory = $('.repertory').val();
		 var faceQuality = $('.faceQuality').val();
		 var price = $('.price').val();
		 if(price=='')
			 {
			 price=0.0;
			 }
		 var place = $('.place').val();
		 var supplier = $('.supplier').val();
		 var unit = $('.unit').val();
		 var amount = $('.amount').val();
		 if(amount=='')
		 {
			 amount=0.0;
		 }
		 if(repertory=='')
		 {
			 repertory=0.0;
		 }
		 var inbatchPrice = $('.inbatchPrice').val();
		 if(inbatchPrice=='')
		 {
			 inbatchPrice=0.0;
		 }
		 var remark = $('.remark').val();
		 
		 $.ajax({
				type: "POST",
				url: 'medicine/mod.do',
				data: {
					'medicineCode':medicineCode,
					'billCode':billCode,
					'medicineName':medicineName,
					'purchaser':purchaser,
					'medicineSpec':medicineSpec,
					'sdate':tproDate,
					'edate':period,
					'probatchCode':probatchCode,
					'certiCode':certiCode,
					'approveCode':approveCode,
					'ckConclusion':ckConclusion,
					'faceQuality':faceQuality,
					'price':price,
					'place':place,
					'supplier':supplier,
					'unit':unit,
					'amount':amount,
					'inbatchPrice':inbatchPrice,
					'repertory':repertory,
					'remark':remark,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('修改成功')
					    $('.mainbody_right').load("pages/medicineManager.jsp");
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
