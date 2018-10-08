<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style>
 .query{
 width: 100%;
 height: 100px;
}
#session1{
 width: 100%;
 height:400px;
}
 .form-inline{
 margin-top:  20px;
 margin-left: 20px;
 }
 .row{
 padding: 10px 0;
 }
 .skip{
	width: 60px;
	display: inline;
}
.pagePosition{
	margin-top:30px;
	margin-left: -10%;
}
.patientInfo{
margin-top: 20px;
margin-left: 40px;
color: #686963;
}
#checkItemList{
margin-left: 20%;
}
</style>
<body>
<div class="query" >
<div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
		         检查类型&nbsp;<input type="text" class="form-control dropdown-toggle checkType" data-toggle="dropdown" placeholder="检查类型">
		      <ul id="checkItemList" class="dropdown-menu" style="height:300px;overflow: scroll;">
         
			 </ul>
		</div>
        <div class="col-lg-4">
			检查部位&nbsp;<input type="text" class="form-control checkPlace" placeholder="检查部位">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
		           标本种类&nbsp;<input type="text" class="form-control specimenType" placeholder="标本种类">
		</div>
        <div class="col-lg-4">
			检查方法&nbsp;<input type="text" class="form-control checkMethod" placeholder="检查方法">
		</div>
		<button class="btn btn-default addCheck" type="button" data-id="${vistid}">添加</button>
	</div>
</form>
</div>
<div id="session">
 <table class="table">
    <caption>检查单</caption>
    <thead>
       <tr class="active">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>科室</th>
            <th>医生</th>
            <th>创建日期</th>
            <th>检查类型</th>
            <th>标本种类</th>
            <th>检查部位</th>
            <th>检查方法</th>
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
<script src="js/doctor/checkForm.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{officeType}}</td>
  <td>{{doctorName}}</td>
  <td>{{createTime}}</td>
  <td>{{checkType}}</td>
  <td>{{specimenType}}</td>
  <td>{{checkPlace}}</td>
  <td>{{checkMethod}}</td>
  <td><a data-id={{id}} data-vistId={{vistId}} class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script> 
</body>
