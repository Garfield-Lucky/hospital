<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<body>
 <form class="form-inline" role="form">
	<div class="row">
	     <div class="col-lg-4">
	     	医生编号：<input type="text" class="form-control doctorCode" placeholder="医生编号">
		</div>
		<div class="col-lg-4">
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" class="form-control doctorName" placeholder="姓名">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text"  class="form-control age" placeholder="年龄">
		</div>
		<div class="col-lg-4">
			性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" class="sex" value="男" checked="checked">男
			        <input type="radio" name="sex" value="女" class="sex">女
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			联系电话：<input type="text"  class="form-control phone" placeholder="联系电话">
		</div>
		<div class="col-lg-4">
			所在科室：<input type="text"  class="form-control officeCode" placeholder="所在科室">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text"  class="form-control title" placeholder="职称">
		</div>
		<div class="col-lg-4">
			挂号费用：<input type="text"  class="form-control registerFee" placeholder="挂号费用">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			门诊类型：<input type="text"  class="form-control clinicType" placeholder="门诊类型">
		</div>
	</div>
	<div class="btn-group">
	  <button type="reset" class="btn btn-default">重置</button>
	  <button type="button" class="btn btn-default addDoctor">保存</button>
    </div>
</form>
<script src="js/common/addDoctor.js"></script>
</body>
 