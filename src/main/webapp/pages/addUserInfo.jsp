<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style>
.userInfo{

width: 300px;
} 
.addUserInfo{
 padding: 5% 10%;
}
 
.rest{
margin-top:30px;
margin-left: 20%;
}
.addUser{
margin-top:30px;
margin-left: 50px;
}
</style>
<script src="js/common/addUserInfo.js"></script> 
<body>
 <div class="addUserInfo">
 <form class="form-inline " role="form">
	<div class="row">
		<div class="col-lg-3 userInfo">
			工号：<input type="text" class="form-control workNum" placeholder="工号">
		</div>
		<div class="col-lg-3 userInfo">
			姓名：<input type="text" class="form-control UserName" placeholder="姓名">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3 userInfo">
			类型：<input type="text" class="form-control userType" placeholder="用户类型">
		</div>
	</div>

	  <button type="reset" class="btn btn-default rest">重置</button>
	  <button type="button" class="btn btn-default addUser">保存</button>
</form>
</div>
</body>
 