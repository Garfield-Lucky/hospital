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
 <script src="js/common/patientDetail.js"></script>
<body>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			姓名：<input type="text" value="${user.userName}" class="form-control userName" placeholder="姓名">
		</div>
		<div class="col-lg-4">
		   <c:if test="${user.sex == '男'}">
			 性别： <input type="radio"  name="sex" class="sex" value="男" checked="checked">男
			     <input type="radio"  name="sex" class="sex" value="女">女
		   </c:if>
		   <c:if test="${user.sex == '女'}">
			 性别： <input type="radio"  name="sex" class="sex" value="男">男
			     <input type="radio"  name="sex" class="sex" value="女" checked="checked">女
		   </c:if>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			年龄：<input type="text" value="${user.age}" class="form-control age" placeholder="年龄">
		</div>
		<div class="col-lg-4">
		   <c:if test="${user.marry == '已婚'}">
			婚姻状况：<input type="radio" name="marry" value="已婚" class="marry" checked="checked">已婚
			        <input type="radio" name="marry" value="未婚" class="marry">未婚
		   </c:if>
		    <c:if test="${user.marry == '未婚'}">
			婚姻状况：<input type="radio" name="marry" value="已婚" class="marry">已婚
			        <input type="radio" name="marry" value="未婚" class="marry" checked="checked">未婚
		   </c:if>
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-4">
			电话：<input type="text" value="${user.phone}" class="form-control phone" placeholder="电话">
		</div>
		<div class="col-lg-4">
			身份证号：<input type="text" value="${user.idCard}" class="form-control idCard" placeholder="身份证号">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-4">
			民族：<input type="text" value="${user.nation}" class="form-control nation" placeholder="民族">
		</div>
		<div class="col-lg-4">
			医疗卡号：<input type="text" value="${user.medicalNum}" class="form-control medicalNum" placeholder="医疗卡号">
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-4">
			地址：<input type="text" value="${user.address}" class="form-control address" placeholder="地址">
		</div>
		<div class="col-lg-4">
			账号余额：<input type="text" value="${user.balanceMedical}" class="form-control balanceMedical" placeholder="账号余额">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			备注：<input type="text" value="${user.remark}" class="form-control remark" placeholder="备注">
		</div>
	</div>
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default mod_user" data-id="${user.userId}">保存</button>
    </div>
</form>
    
</body>
 