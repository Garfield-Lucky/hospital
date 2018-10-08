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
 .diagnoseResult{
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
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-5 diagnoseResult">
		          <textarea  class="form-control result" cols="75" rows="5" placeholder="诊断结果"></textarea>
		</div>
         
		<button class="btn btn-default addDiagnose" type="button" data-id="${vistid}">提交</button>
	</div>
</form>
</div>
 <div id="session1">
 <table class="table">
    <caption>诊断单</caption>
    <thead>
       <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>就诊时间</th>
        </tr>
    </thead>
    <tbody id="diagnose_list">
        
    </tbody>
</table>
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/doctor/diagnoseForm.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{sex}}</td>
  <td>{{age}}</td>
  <td>{{seeTime}}</td>
 {{/each}}
</script> 
</body>
