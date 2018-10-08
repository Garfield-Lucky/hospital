<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 医生值班安排管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/user/doctorWorkManager.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			医生编号&nbsp;<input type="text" class="form-control doctorCode" data-code="" placeholder="医生编号">
		</div>
        <div class="col-lg-4">
			看号数&nbsp;<input type="text" class="form-control registerCount" data-count="" placeholder="看号数">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			值班日期&nbsp;<input type="text" id="d421" class="form-control Wdate workDate" data-date="" onClick="WdatePicker({skin:'whyGreen'})" placeholder="值班日期">
		</div>
        <div class="col-lg-3">
			时间段&nbsp;<input type="text" class="form-control workTime" data-time="" placeholder="时间段">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
		<button class="btn btn-default add" type="button">新增</button>
	</div>
</form>
</div>
<div id="session">
 <table class="table">
    <caption>医生值班安排管理</caption>
    <thead>
        <tr class="headers">
            <th>医生编号</th>
            <th>姓名</th>
            <th>所在科室</th>
            <th>值班日期</th>
            <th>值班时间</th>
            <th>当天看号数</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="doctorWork_list">
        
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
<script src="js/user/doctorWorkManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{doctorCode}}</td>
  <td>{{doctorName}}</td>
  <td>{{officeType}}</td>
  <td>{{workDate}}</td>
  <td>{{workTime}}</td>
  <td>{{registerCount}}</td>
  <td><a class="glyphicon glyphicon-edit update" data-id={{id}}></a> <a data-id={{id}}  class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>    
</body>
