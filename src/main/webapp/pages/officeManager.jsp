<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<!-- 科室管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/user/officeManager.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3 officeCode">
			科室编号&nbsp;<input type="text" class="form-control Code" data-code="" placeholder="科室编号">
		</div>
        <div class="col-lg-3 officeType">
			科室类型&nbsp;<input type="text" class="form-control Type" data-type="" placeholder="科室类型">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
		<button class="btn btn-default add" type="button">新增</button>
	</div>
</form>
</div>
<div id="session1">
 <table class="table">
    <caption>用户信息管理</caption>
    <thead>
        <tr class="headers">
            <th>科室编号</th>
            <th>科室类型</th>
            <th>地理位置</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="office_list">
        
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
<script src="js/user/officeManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{officeCode}}</td>
  <td>{{officeType}}</td>
  <td>{{address}}</td>
  <td><a data-id={{id}} class="glyphicon glyphicon-edit update"></a><a data-id={{officeCode}} class="glyphicon glyphicon-trash del"></td>
 </tr>
 {{/each}}
</script>   
</body>
