<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="css/register/registerBack.css">
<body>
<div class="query" >
	<form class="bs-example bs-example-form" role="form">
		<div class="row">
			<div class="col-lg-4">
				<div class="input-group">
					<input type="text" class="form-control userId" data-id="" placeholder="用户id">
					<span class="input-group-btn">
						<button class="btn btn-default find" type="button">
							查找
						</button>
					</span>
				</div>
			</div>
		</div>
	</form>
</div>
<div id="session1">
<table class="table">
    <caption>退号管理</caption>
    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>收费类型</th>
            <th>医生姓名</th>
            <th>科室</th>
            <th>挂号时间</th>
            <th>状态</th>
            <th>操作</th>
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
<script src="js/register/registerBack.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{feetype}}</td>
  <td>{{doctorName}}</td>
  <td>{{officeType}}</td>
  <td>{{createTime}}</td>
  <td>{{flag}}</td>
  <td><span data-vistId={{vistId}} data-status={{status}} class="back">退号</span> </td>
 </tr>
 {{/each}}
</script>  
</body>
