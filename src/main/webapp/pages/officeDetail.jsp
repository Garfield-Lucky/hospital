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
  
</style>
<body>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			科室编号：<input type="text" value="${office.officeCode}" class="form-control officeCode" readonly="readonly" placeholder="科室编号">
		</div>
		<div class="col-lg-4">
			科室类型：<input type="text" value="${office.officeType}" class="form-control officeType" placeholder="科室类型">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			地理位置：<input type="text" value="${office.address}" class="form-control address" placeholder="地理位置">
		</div>
	</div>
	 
	<div class="btn-group">
	  <button type="button" class="btn btn-default" onClick="javascript:window.history.go(0)">取消</button>
	  <button type="button" class="btn btn-default mod_office" data-id="${office.id}">保存</button>
    </div>
</form>
 <script src="js/common/officeDetail.js"></script>
</body>
 