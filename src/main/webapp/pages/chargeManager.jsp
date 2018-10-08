<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  收费结算 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/charge/chargeManager.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3">
			开始时间&nbsp;<input type="text" id="d421" class="form-control Wdate stime"  onClick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" placeholder="开始时间">
		</div>
        <div class="col-lg-3">
			结束时间&nbsp;<input type="text" id="d421" class="form-control Wdate etime"  onClick="WdatePicker({skin:'whyGreen'})" placeholder="结束时间">
		</div>
		<button class="btn btn-default jiesuan" type="button">结算</button>
	</div>
</form>
</div>
<div id="session1">
<table class="table">
    <caption>收费结算</caption>
    <thead>
        <tr class="headers">
            <th>结算员</th>
            <th>检查类</th>
            <th>药品类</th>
            <th>合计</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>结算时间</th>
        </tr>
    </thead>

    <tbody id="chargeCount">
        
    </tbody>
</table>
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/charge/chargeManager.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{clerk}}</td>
  <td>{{checkCategory}}</td>
  <td>{{medicineCategory}}</td>
  <td>{{total}}</td>
  <td>{{stime}}</td>
  <td>{{etime}}</td>
  <td>{{time}}</td>
 </tr>
 {{/each}}
</script>
</body>
 