<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/register/registerManager.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/echarts/echarts.min.js"></script>
<body>
<div class="query" >
 <form class="form-inline registerManager" role="form">
	<div class="row">
		<div class="col-lg-4">
			开始时间&nbsp;<input type="text" id="d421" class="form-control Wdate stime"  onClick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" placeholder="开始时间">
		</div>
        <div class="col-lg-4">
			结束时间&nbsp;<input type="text"  class="form-control Wdate etime" onClick="WdatePicker({skin:'whyGreen'})" placeholder="结束时间">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
	</div>
</form>
</div>
<div id="session1">
  <table class="table">
    <caption>挂号统计</caption>
    <thead>
        <tr class="headers">
            <th>挂号量</th>
            <th>退号量</th>
            <th>挂号费</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
    </thead>
    <tbody id="count_list">
        
    </tbody>
</table>
<div id="main"></div>
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/register/registerManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr class="danger">
  <td>{{registerNum}}</td>
  <td>{{tuihaoNum}}</td>
  <td>{{registerFee}}</td>
  <td>{{stime}}</td>
  <td>{{etime}}</td>
 </tr>
 {{/each}}
</script>  
 
</body>
