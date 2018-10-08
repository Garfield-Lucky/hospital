<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 诊断单管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/doctor/diagnoseManager.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3">
			挂号序号&nbsp;<input type="text" class="form-control vistId" data-vistId="" placeholder="挂号序号">
		</div>
        <div class="col-lg-3">
			用户id&nbsp;<input type="text" class="form-control userId" data-userId="" placeholder="用户id">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
	</div>
</form>
</div>
<div id="session1">
<table class="table">
    <caption>诊断单列表</caption>
    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>科室</th>
            <th>医生姓名</th>
            <th>诊断结果</th>
            <th>就诊日期</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="diagnose_list">
      
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
<script src="js/doctor/diagnoseManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{officeType}}</td>
  <td>{{doctorName}}</td>
  <td><a><span class="glyphicon glyphicon-search see" data-content="{{diagnose}}" data-userId="{{userId}}" data-userName="{{userName}}"></span></a></td>
  <td>{{seeTime}}</td>
  <td><a data-vistId="{{vistId}}" data-content="{{diagnose}}" data-userId="{{userId}}" data-userName="{{userName}}" class="glyphicon glyphicon-edit update"></a> </td>
 </tr>
 {{/each}}
</script>     
</body>
 