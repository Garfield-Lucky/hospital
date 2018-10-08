<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 处方单管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/patient/patientPress.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			开始时间&nbsp;<input type="text" id="d421" class="form-control Wdate stime" data-stime="" onClick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" placeholder="开始时间">
		</div>
        <div class="col-lg-4">
			结束时间&nbsp;<input type="text" id="d421" class="form-control Wdate etime" data-etime="" onClick="WdatePicker({skin:'whyGreen'})" placeholder="结束时间">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
	</div>
</form>
</div>
<div id="session1">
<table class="table">
    <caption>处方单管理</caption>
    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>药品名</th>
            <th>规格</th>
            <th>数量</th>
            <th>医生姓名</th>
            <th>处方日期</th>
            <th>备注</th>
        </tr>
    </thead>
    <tbody id="pres_list">
      
    </tbody>
</table>
 <ul class="pager pagePosition">
    <li><a id="firstPage">首页</a></li>
	<li><a id="prevPage">上一页</a></li>
	<li><a id="nextPage">下一页</a></li>
	<li><a id="trailPage">尾页</a></li>
	<li><span><span id="currentPage"></span>/<span id="countPage"></span></span></li>
	<li><input type="text" class="form-control skip" id="pageNum"></li>
	<li><a id="query">查询</a></li>
 </ul>
</div>
 <script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/patient/patientPres.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{medicinName}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{count}}</td>
  <td>{{doctorName}}</td>
  <td>{{createTime}}</td>
  <td>{{remark}}</td>
 </tr>
 {{/each}}
</script>     
</body>
 