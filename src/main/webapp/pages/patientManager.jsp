<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 用户信息管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/user/patientManager.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3">
			用户id&nbsp;<input type="text" class="form-control userId" data-id="" placeholder="病人id">
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
    <caption>用户信息管理</caption>
    <thead>
        <tr class="headers">
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>医疗卡号</th>
            <th>余额</th>
            <th>联系电话</th>
            <th>身份证号</th>
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
<script class="userManager" src="js/user/patientManager.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{medicalNum}}</td>
  <td>{{balanceMedical}}</td>
  <td>{{phone}}</td>
  <td>{{idCard}}</td>
  <td><a class="glyphicon glyphicon-edit detail" data-id={{userId}}></a> <a data-id={{userId}}  class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>   
</body>
