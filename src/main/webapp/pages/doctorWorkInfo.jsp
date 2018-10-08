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
	     <div class="col-lg-3">
	     	医生编号：<input type="text" value="D1001" class="form-control" placeholder="医生编号">
		</div>
		<div class="col-lg-3">
			看号数：<input type="text" value="30" class="form-control" placeholder="看号数">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			值班日期：<input type="text" value="2017-03-25" class="form-control" placeholder="值班日期">
		</div>
		<div class="col-lg-3">
			时间段：<input type="text" value="上午" class="form-control" placeholder="时间段">
		</div>
	</div>
	 
	<div class="btn-group">
	  <button type="button" class="btn btn-default">取消</button>
	  <button type="button" class="btn btn-default">保存</button>
    </div>
</form>

</body>
 