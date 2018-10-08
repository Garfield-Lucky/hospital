 $(function(){
	 $(".addMedicine").on('click',function(){
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
		 var inbatchPrice = $('.inbatchPrice').val();
		 if(inbatchPrice=='')
		 {
			 inbatchPrice=0.0;
		 }
		 var remark = $('.remark').val();
		 
		 $.ajax({
				type: "POST",
				url: 'medicine/add.do',
				data: {
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
					'repertory':amount,
					'remark':remark,
					'status':0
				},
				dataType:'json',
				success : function(data) {
					if(data.flag){
						alert('添加成功')
					 //   $('.mainbody_right').load("pages/medicineManager.jsp");
					}else{
						 alert('添加失败')
							}
						},
					error : function() {
						alert("异常");
						}
					});
	     });
     
 });