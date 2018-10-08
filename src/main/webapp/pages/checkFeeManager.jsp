<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<!-- 检查检验费用管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/user/checkFeeManager.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4 checkCode">
			项目编码&nbsp;<input type="text" class="form-control Code" data-code="" placeholder="项目编码">
		</div>
        <div class="col-lg-3 checkItem">
			项目名称&nbsp;<input type="text" class="form-control Name" data-name="" placeholder="项目名称">
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
            <th>项目编码</th>
            <th>项目名称</th>
            <th>检查费用</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="checkFee_list">
        
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
<script src="js/user/checkFeeManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{checkCode}}</td>
  <td>{{checkItem}}</td>
  <td>{{expend}}</td>
  <td><a class="glyphicon glyphicon-edit update" data-id={{checkCode}}></a> <a data-id={{checkCode}}  class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>  
</body>
