<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style>
 .query{
 width: 100%;
 height: 100px;
}
#session1{
 width: 100%;
 height:400px;
}
 .form-inline{
 margin-top:  20px;
 margin-left: 20px;
 }
 .row{
 padding: 10px 0;
 }
 .checkResult{
 width: 800px;
 }
 .updateCheckResult{
  margin-top:30px;
  margin-left: 100px;
  }
.patientInfo{
margin-top: 20px;
margin-left: 40px;
color: #686963;
}
</style>
<body>
<div class="query" >
<div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
 <form class="form-inline" id="form1"  role="form" name="userForm2" action="check/updateCheckResult.do"  enctype="multipart/form-data" method="post">
	<div class="row">
		<div class="col-lg-5 checkResult">
		          <textarea  class="form-control checkContent" name="checkResult" cols="75" rows="5" placeholder="诊断结果">${checkResult}</textarea>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-5 photo">
		       <input type="file" id="photo" name="file">  
		</div>
		<input type="text" name="id" value="${id}" style="display: none">  
	</div>
		<div class="row">
		<button class="btn btn-default updateCheckResult" type="button" data-id="${id}">更改</button>
	</div>
</form>
</div>
<script src="js/jquery/jquery.form.min.js"></script>
<script src="js/check/checkResultUpdate.js"></script>
</body>
