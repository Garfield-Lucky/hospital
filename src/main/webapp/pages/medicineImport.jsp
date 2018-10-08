<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  药品入库 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/medicine/medicineImport.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script src="js/medicine/medicineImport.js"></script>
<body>
 <form class="form-inline medicineimport" role="form">
	<div class="row">
		<div class="col-lg-3">
		发票号码：<input type="text" class="form-control billCode" placeholder="发票号码">
		</div>
		<div class="col-lg-3">
		药品名称：<input type="text" class="form-control medicineName" placeholder="药品名称">
		</div>
		<div class="col-lg-3">
		采购员：<input type="text" class="form-control purchaser" placeholder="采购员">
		</div>
		
	</div>
	<div class="row">
	    <div class="col-lg-3">
		          药品规格：<input type="text" class="form-control medicineSpec" placeholder="药品规格">
		</div>
		<div class="col-lg-3">
			生产日期：<input type="text" id="d421" class="form-control Wdate tproDate"  onClick="WdatePicker({skin:'whyGreen'})" placeholder="生产日期">
		</div>
		<div class="col-lg-3">
			有效期：<input type="text" id="d421" class="form-control Wdate period"  onClick="WdatePicker({skin:'whyGreen'})" placeholder="有效期">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-3">
			生产批号：<input type="text" class="form-control probatchCode" placeholder="生产批号">
		</div>
		<div class="col-lg-3">
			合格证号：<input type="text" class="form-control certiCode" placeholder="合格证号">
		</div>
		<div class="col-lg-3">
			批文号：<input type="text" class="form-control approveCode" placeholder="批文号">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			验收结论：<input type="text" class="form-control ckConclusion" placeholder="验收结论">
		</div>
		<div class="col-lg-3">
			外观质量：<input type="text" class="form-control faceQuality" placeholder="外观质量">
		</div>
		<div class="col-lg-3">
			单&nbsp;&nbsp;&nbsp;&nbsp;价：<input type="text" class="form-control price" placeholder="单价">
		</div>
	</div>
	 
	<div class="row">
	    <div class="col-lg-3">
		          药品产地：<input type="text" class="form-control place" placeholder="药品产地">
	    </div>
		<div class="col-lg-3">
			供货单位：<input type="text" class="form-control supplier" placeholder="供货单位">
		</div>
		<div class="col-lg-3">
			单&nbsp;&nbsp;&nbsp;&nbsp;位：<input type="text" class="form-control unit" placeholder="单位">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			入库数量：<input type="text" class="form-control amount" placeholder="入库数量">
		</div>
		<div class="col-lg-3">
			入库批价：<input type="text" class="form-control inbatchPrice" placeholder="入库批价">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-5">
			备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" class="form-control remark" placeholder="备注">
		</div>
	</div>
	<div class="btn-group">
	  <button type="reset" class="btn btn-default">重置</button>
	  <button type="button" class="btn btn-default addMedicine">保存</button>
    </div>
</form>

</body>
 