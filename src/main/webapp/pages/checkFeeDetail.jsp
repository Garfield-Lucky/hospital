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
			项目编码：<input type="text" value="${checkFee.checkCode}" class="form-control checkCode" placeholder="项目编码">
		</div>
		<div class="col-lg-4">
			项目名称：<input type="text" value="${checkFee.checkItem}" class="form-control checkItem" placeholder="项目名称">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			检查费用：<input type="text" value="${checkFee.expend}" class="form-control expend" placeholder="检查费用">
		</div>
	</div>
	 
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default mod_checkFee">保存</button>
    </div>
</form>
<script src="js/common/checkFeeDetail.js"></script>
</body>
 