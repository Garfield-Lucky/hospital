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
<script src="js/common/addPatientInfo.js"></script> 
<body>
 <div class="addUserInfo">
 <form class="form-inline " role="form">
	<div class="row">
		<div class="col-lg-3 userInfo">
			姓名：<input type="text" class="form-control UserName" placeholder="姓名">
		</div>
		<div class="col-lg-3 userInfo">
			性别： <input type="radio"  name="sex" value="男" class="sex" checked="checked">男
			     <input type="radio"  name="sex" value="女" class="sex">女
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3 userInfo">
			年龄：<input type="text" class="form-control age" placeholder="年龄">
		</div>
		<div class="col-lg-3 userInfo">
			婚姻状况：<input type="radio" name="marry" value="已婚" class="marry">已婚
			        <input type="radio" name="marry" value="未婚" class="marry" checked="checked">未婚
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-3 userInfo">
			电话：<input type="text" class="form-control phone" placeholder="电话">
		</div>
		<div class="col-lg-3 userInfo"> 
			身份证号：<input type="text" class="form-control idCard" placeholder="身份证号">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-3 userInfo">
			民族：<input type="text" class="form-control nation" placeholder="民族">
		</div>
		<div class="col-lg-3 userInfo">
			医疗卡号：<input type="text" class="form-control medicalNum" placeholder="医疗卡号">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-3 userInfo">
			地址：<input type="text" class="form-control address" placeholder="地址">
		</div>
		<div class="col-lg-3 userInfo">
			备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" class="form-control remark" placeholder="备注">
		</div>
	</div>
 
	  <button type="reset" class="btn btn-default rest">重置</button>
	  <button type="button" class="btn btn-default addUser">保存</button>
</form>
</div>
</body>
 