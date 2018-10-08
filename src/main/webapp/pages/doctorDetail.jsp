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
<script src="js/common/doctorDetail.js"></script>
<body>
 <form class="form-inline" role="form">
	<div class="row">
	     <div class="col-lg-4">
	     	医生编号：<input type="text" value="${doctor.doctorCode}" class="form-control doctorCode" readonly="readonly"  placeholder="医生编号">
		</div>
		<div class="col-lg-4">
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" value="${doctor.doctorName}" class="form-control doctorName" placeholder="姓名">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text" value="${doctor.age}" class="form-control age" placeholder="年龄">
		</div>
		<div class="col-lg-4">
		  <c:if test="${doctor.sex == '男'}">
			性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" value="男" checked="checked" class="sex">男
			        <input type="radio" name="sex" value="女" class="sex">女
		   </c:if>
		   <c:if test="${doctor.sex == '女'}">
			性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" value="男" class="sex">男
			        <input type="radio" name="sex" value="女" checked="checked" class="sex">女
		   </c:if>
			
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			联系电话：<input type="text" value="${doctor.phone}" class="form-control phone" placeholder="联系电话">
		</div>
		<div class="col-lg-4">
			科室编码：<input type="text" value="${doctor.officeCode}" class="form-control officeCode" placeholder="科室编码">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" value="${doctor.title}" class="form-control title" placeholder="职称">
		</div>
		<div class="col-lg-4">
			挂号费用：<input type="text" value="${doctor.registerFee}" class="form-control registerFee" placeholder="挂号费用">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			门诊类型：<input type="text" value="${doctor.clinicType}" class="form-control clinicType" placeholder="门诊类型">
		</div>
	</div>
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default mod_doctor" >保存</button>
    </div>
</form>

</body>
 