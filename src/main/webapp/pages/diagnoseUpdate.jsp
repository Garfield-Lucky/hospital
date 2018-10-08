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
 padding: 30px 30px;
 }
 .diagnoseResult{
 width: 800px;
 }
  .updateDiagnose{
  margin-left: 15px;
  margin-top: 10px;
  }
.patientInfo{
margin-top: 20px;
margin-left: 70px;
color: #686963;
}
</style>
<body>
<div class="query" >
<div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-5 diagnoseResult">
		          <textarea  class="form-control diagnose"  cols="75" rows="15" placeholder="诊断结果">${diagnose}</textarea>
		</div>
	</div>
	<div class="row">
		<button class="btn btn-default updateDiagnose" type="button" data-id="${vistId}">更改</button>
	</div>
</form>
</div>
<script src="js/doctor/diagnoseUpdate.js"></script>
</body>
