<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<!--  医生诊断 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/doctor/diagnose.css">
<body>
<div class="query" >
 <form class="form-inline diagnose" role="form">
	<div class="row">
		<div class="col-lg-3">
			挂号序号&nbsp;<input type="text" class="form-control vistId" data-vistId="" placeholder="挂号序号">
		</div>
        <div class="col-lg-3">
			姓名&nbsp;<input type="text" class="form-control userName" data-name="" placeholder="姓名">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
	</div>
</form>
</div>
<div id="session1">
 <table class="table">
    <caption>诊断列表</caption>

    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>就诊状态</th>
            <th>检查单</th>
            <th>诊断</th>
            <th>处方单</th>
        </tr>
    </thead>
    <tbody id="register_list">
    
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
<script src="js/doctor/diagnose.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{flag}}</td>
  <td class="checkForm" data-vistId="{{vistId}}"  data-userId="{{userId}}" data-userName="{{userName}}"><span class="glyphicon glyphicon-plus" style="font-size: 12px;color:#3399D2; margin-right:5px;"></span>检查单</td>
  <td class="diagnoseForm" data-vistId="{{vistId}}"  data-userId="{{userId}}" data-userName="{{userName}}"><span class="glyphicon glyphicon-plus" style="font-size: 12px;color:#3399D2; margin-right:5px;"></span>诊断</td>
  <td class="presForm"  data-vistId="{{vistId}}"  data-userId="{{userId}}" data-userName="{{userName}}"><span class="glyphicon glyphicon-plus" style="font-size: 12px;color:#3399D2; margin-right:5px;"></span>处方单</td>
 </tr>
 {{/each}}
</script>  
</body>

