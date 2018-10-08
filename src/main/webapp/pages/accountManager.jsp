<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  账户管理 -->
<link rel="stylesheet" type="text/css" href="css/user/accountManager.css">
<script src="js/user/accountManager.js"></script>
<body>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3">
			原密码：<input type="password" class="form-control passwordOld" placeholder="原密码">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			新密码：<input type="password" class="form-control passwordNew1" placeholder="新密码">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			新密码：<input type="password" class="form-control passwordNew2" placeholder="新密码">
		</div>
	</div>
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default save">保存</button>
    </div>
</form>

</body>
 