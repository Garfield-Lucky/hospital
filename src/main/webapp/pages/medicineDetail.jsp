<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<style>
  
 .form-inline{
 margin-top:  50px;
 margin-left: 20px;
 }
 .row{
 padding: 5px 0;
 }
 .btn-group{
 margin-left: 30%; 
 margin-top: 50px;
 }
  
</style>
<body>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
		发票号码：<input type="text"  value="${medicine.billCode}" class="form-control billCode" placeholder="发票号码">
		</div>
		<div class="col-lg-4">
		药品名称：<input type="text"  value="${medicine.medicineName}" class="form-control medicineName" placeholder="药品名称">
		</div>
		<div class="col-lg-4">
		采购员：<input type="text"   value="${medicine.purchaser}" class="form-control purchaser" placeholder="采购员">
		</div>
	</div>
	<div class="row">
	    <div class="col-lg-4">
		          药品规格：<input type="text"  value="${medicine.medicineSpec}" class="form-control medicineSpec" placeholder="药品规格">
		</div>
		<div class="col-lg-4">
			生产日期：<input type="text"  value="${proDate}" class="form-control tproDate" placeholder="生产日期">
		</div>
		<div class="col-lg-4">
			有效期：<input type="text"  value="${period}" class="form-control period" placeholder="有效期">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-4">
			生产批号：<input type="text"  value="${medicine.probatchCode}" class="form-control probatchCode" placeholder="生产批号">
		</div>
		<div class="col-lg-4">
			合格证号：<input type="text"  value="${medicine.certiCode}" class="form-control certiCode" placeholder="合格证号">
		</div>
		<div class="col-lg-4">
			批文号：<input type="text"   value="${medicine.approveCode}" class="form-control approveCode" placeholder="批文号">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			验收结论：<input type="text" value="${medicine.ckConclusion}" class="form-control ckConclusion" placeholder="验收结论">
		</div>
		<div class="col-lg-4">
			外观质量：<input type="text" value="${medicine.faceQuality}" class="form-control faceQuality" placeholder="外观质量">
		</div>
		<div class="col-lg-4">
			单&nbsp;&nbsp;&nbsp;&nbsp;价：<input type="text" value="${medicine.price}" class="form-control price" placeholder="单价">
		</div>
	</div>
	 
	<div class="row">
	    <div class="col-lg-4">
		          药品产地：<input type="text" value="${medicine.place}" class="form-control place" placeholder="药品产地">
	    </div>
		<div class="col-lg-4">
			供货单位：<input type="text" value="${medicine.supplier}" class="form-control supplier" placeholder="供货单位">
		</div>
		<div class="col-lg-4">
			单&nbsp;&nbsp;&nbsp;&nbsp;位：<input type="text" value="${medicine.unit}" class="form-control unit" placeholder="单位">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			入库数量：<input type="text" value="${medicine.amount}" class="form-control amount" placeholder="入库数量">
		</div>
		<div class="col-lg-4">
			入库批价：<input type="text" value="${medicine.inbatchPrice}" class="form-control inbatchPrice" placeholder="入库批价">
		</div>
		<div class="col-lg-4">
			库&nbsp;&nbsp;&nbsp;&nbsp;存：<input type="text" value="${medicine.repertory}" class="form-control repertory" placeholder="库存">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-5">
			备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" value="${medicine.remark}" class="form-control remark" placeholder="备注">
		</div>
	</div>
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default mod_medicine" data-id="${medicine.medicineCode}">保存</button>
    </div>
</form>
<script src="js/common/medicineDetail.js"></script>
</body>
 