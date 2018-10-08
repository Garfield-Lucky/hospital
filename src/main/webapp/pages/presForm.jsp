<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style>
 .query{
 width: 100%;
 height: 100px;
 margin-top: 5px;
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
#medicineList{
margin-left: 20%;
}
#specList{
margin-left: 12%;
}
</style>
<body>
<div class="query" >
 <div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
		          药品名称&nbsp;<input type="text" class="form-control dropdown-toggle medicinName" data-toggle="dropdown" placeholder="药品名称">
		     <ul id="medicineList" class="dropdown-menu" style="height:300px;overflow: scroll;">
         
			 </ul>
		</div>
        <div class="col-lg-4">
			规格&nbsp;<input type="text" class="form-control medicineSpec" data-toggle="dropdown" placeholder="规格">
		   <ul id="specList" class="dropdown-menu" style="height:100px;">
         
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
		           数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量&nbsp;<input type="text" class="form-control number" placeholder="数量">
		</div>
        <div class="col-lg-4">
			备注&nbsp;<input type="text" class="form-control remark" placeholder="备注">
		</div>
		<button class="btn btn-default addPress" type="button" data-id="${vistid}">添加</button>
	</div>
</form>
</div>
<div id="session">
 <table class="table">
    <caption>处方单</caption>
    <thead>
       <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>药品名</th>
            <th>规格</th>
            <th>数量</th>
            <th>医生姓名</th>
            <th>处方日期</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="pres_list">
        
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
<script src="js/doctor/presForm.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{medicinName}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{count}}</td>
  <td>{{doctorName}}</td>
  <td>{{createTime}}</td>
  <td>{{remark}}</td>
  <td><a data-id={{id}} data-vistId={{vistId}} class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>  
</body>
