<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 用户信息管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/user/userManager.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3">
			工号&nbsp;<input type="text" class="form-control workNum" data-id="" placeholder="工号">
		</div>
        <div class="col-lg-3">
			姓名&nbsp;<input type="text" class="form-control userName" data-name="" placeholder="姓名">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
		<button class="btn btn-default addUser" type="button">新增</button>
	</div>
</form>
</div>
<div id="session1">
 <table class="table">
    <caption>用户信息管理</caption>
    <thead>
        <tr class="headers">
            <th>工号</th>
            <th>姓名</th>
            <th>类型</th>
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
<!--     <ul class="pager"> -->
<!-- 	<li class="previous"><a href="#">&larr; Older</a></li> -->
<!-- 	<li class="next"><a href="#">Newer &rarr;</a></li> -->
<!--     </ul> -->
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script class="userManager" src="js/user/userManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{workNum}}</td>
  <td>{{userName}}</td>
  <td>{{userType}}</td>
  <td><a data-id={{workNum}} class="glyphicon glyphicon-edit detail"></a><a data-id={{workNum}} class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>   
</body>
