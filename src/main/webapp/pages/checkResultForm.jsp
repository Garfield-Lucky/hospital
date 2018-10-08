<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style>
 .query{
 width: 100%;
 height: 100px;
}
#session{
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
 .checkResult{
 width: 700px;
 }
.patientInfo{
margin-top: 20px;
margin-left: 40px;
color: #686963;
} 
</style>
<body>
<div class="query" >
<div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
 <form class="form-inline" id="form1" role="form" name="userForm2" action="check/writeCheckResult.do"  enctype="multipart/form-data" method="post">
	<div class="row">
		<div class="col-lg-5 photo">
		       <input type="file" id="photo" name="file">  
		</div>
	</div>
	<div class="row">
		<div class="col-lg-5 checkResult">
		         <textarea  class="form-control check_result" name="checkResult" cols="75" rows="5" placeholder="检查结果"></textarea>
		</div>
        <input type="text" name="id" value="${id}" style="display: none">  
		<input class="btn btn-default addCheckResult" type="button" value="提交" data-id="${id}">
	</div>
</form>
</div>
 <div id="session">
 <table class="table">
    <caption>检查结果</caption>
    <thead>
       <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>检查时间</th>
        </tr>
    </thead>
    <tbody id="check_list">
        
    </tbody>
</table>
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script src="js/jquery/jquery.form.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/check/checkResultForm.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{checkTime}}</td>
 {{/each}}
</script> 
</body>
