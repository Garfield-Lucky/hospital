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
 <script src="js/common/userDetail.js"></script>
<body>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			工号：<input type="text" value="${user.userName}" class="form-control workNum" placeholder="工号">
		</div>
		<div class="col-lg-4">
			姓名：<input type="text" value="${user.trueName}" class="form-control userName" placeholder="姓名">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			类型：<input type="text" value="${user.userType}" class="form-control userType" placeholder="用户类型">
		</div>
	</div>
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default mod_user" data-id="${user.userName}">保存</button>
    </div>
</form>
    
</body>
 