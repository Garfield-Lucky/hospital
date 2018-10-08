<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<!--  医生检查单管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/doctor/checkManager.css">
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
    <caption>检查单管理</caption>
    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>检查类型</th>
            <th>检查状态</th>
            <th>检查报告</th>
            <th>医生姓名</th>
            <th>创建日期</th>
            <th>检查日期</th>
            <th>检查员</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="check_list">
        
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
<script src="js/doctor/checkManager.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr class="{{style}}">
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{checkType}}</td>
  <td>{{status}}</td>
  <td ><a><span class="glyphicon glyphicon-search see" data-status="{{status}}" data-content="{{checkResult}}" data-userId="{{userId}}" data-userName="{{userName}}" data-photo="{{checkPhoto}}"></span></a></td>
  <td>{{doctorName}}</td>
  <td>{{createTime}}</td>
  <td>{{checkTime}}</td>
  <td>{{checkPerson}}</td>
  <td><a data-id={{id}} data-vistId={{vistId}}   class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>  
</body>
 