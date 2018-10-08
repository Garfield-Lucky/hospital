<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  登记患者信息 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/register/registerInfo.css">
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-3">
			用户id&nbsp;<input type="text" class="form-control userId" placeholder="用户id">
		</div>
        
		<button class="btn btn-default find" type="button">查找</button>
		<button class="btn btn-default add" type="button">新增</button>
	</div>
</form>
</div>
<div id="session1">
  <table class="table">
    <caption>用户信息</caption>
    <thead>
        <tr class="headers">
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>医疗卡号</th>
            <th>余额</th>
            <th>联系电话</th>
            <th>身份证号</th>
            <th>建档日期</th>
        </tr>
    </thead>
    <tbody id="user_list">
       
    </tbody>
</table>
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/register/registerInfo.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr class="success">
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{medicalNum}}</td>
  <td>{{balanceMedical}}</td>
  <td>{{phone}}</td>
  <td>{{idCard}}</td>
  <td>{{createTime}}</td>
 </tr>
 {{/each}}
</script> 
</body>
 