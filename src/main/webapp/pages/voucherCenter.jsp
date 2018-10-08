<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  充值中心 -->
<link rel="stylesheet" type="text/css" href="css/charge/voucherCenter.css">
<script src="js/charge/voucherCenter.js"></script>
<body>
 <form class="form-inline voucher" role="form">
	<div class="row">
		<div class="col-lg-3">
			用户id：<input type="text" class="form-control userid" placeholder="用户id">
		</div>
		<div class="col-lg-3">
			充值金额：<input type="text" class="form-control money" placeholder="充值金额">
		</div>
		<button type="button" class="btn btn-default save">充值</button>
	</div>
	 
</form>

</body>
 