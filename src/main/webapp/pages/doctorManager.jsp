<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 医生信息管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/user/doctorManager.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			医生编号&nbsp;<input type="text" class="form-control doctorCode" data-code="" placeholder="医生编号">
		</div>
        <div class="col-lg-3">
			姓名&nbsp;<input type="text" class="form-control doctorName" data-name="" placeholder="姓名">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
		<button class="btn btn-default add" type="button">新增</button>
	</div>
</form>
</div>
<div id="session1">
 <table class="table">
    <caption>医生信息管理</caption>
    <thead>
        <tr class="headers">
            <th>医生编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>职称</th>
            <th>联系电话</th>
            <th>所在科室</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="user_list">
         
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
<script src="js/user/doctorManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{doctorCode}}</td>
  <td>{{doctorName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{title}}</td>
  <td>{{phone}}</td>
  <td>{{officeCode}}</td>
  <td><a class="glyphicon glyphicon-edit update" data-id={{doctorCode}}></a> <a data-id={{doctorCode}}  class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>   
</body>
