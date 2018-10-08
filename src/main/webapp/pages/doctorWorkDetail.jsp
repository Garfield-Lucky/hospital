<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<style>
 .form-control{
 width:50px;
 }
 .form-inline{
 margin-top:  50px;
 margin-left: 20px;
 }
 .row{
 padding: 5px 0;
 }
 .btn-group{
 margin-left: 20%;
 margin-top: 50px;
 }
 .Wdate{
 height: 35px;
 }
</style>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<body>
 <form class="form-inline" role="form">
	<div class="row">
	     <div class="col-lg-4">
	     	医生编号：<input type="text" value="${doctor.doctorCode}" class="form-control doctorCode" placeholder="医生编号">
		</div>
		<div class="col-lg-4">
			看号数：<input type="text" value="${doctor.registerCount}" class="form-control registerCount" placeholder="看号数">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			值班日期：<input type="text" value="${workDate}" id="d421" class="form-control Wdate workDate"  onClick="WdatePicker({skin:'whyGreen'})" placeholder="值班日期">
		</div>
		<div class="col-lg-4">
			时间段：<input type="text" value="${doctor.workTime}" class="form-control workTime" placeholder="时间段">
		</div>
	</div>
	 
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default mod_doctorWork" data-id="${doctor.id}">保存</button>
    </div>
</form>
<script src="js/common/doctorWorkDetail.js"></script>
</body>
 