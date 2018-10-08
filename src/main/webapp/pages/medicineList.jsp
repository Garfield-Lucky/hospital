<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="css/common/common.css"> 
<style>
 
  .buttom{
  position:absolute;
  right:10%;
  bottom:-40%;
  }
 .buttom .quyao{
   margin-left: 0px;
 }
 .quyao{
 background-color: #FF802C;
 }
 .skip{
	width: 60px;
	display: inline;
}
.pagePosition{
	margin-top:30px;
	margin-left: -10%;
}
.table{
margin-top: 20px;
}
.patientInfo{
margin-top: 20px;
margin-left: 10px;
color: #686963;
}
</style>
<body>
<div id="session1">
<div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
 <table class="table" data-id="${vistId}">
    <caption>处方</caption>
    <thead>
       <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>药品名</th>
            <th>规格</th>
            <th>数量</th>
            <th>处方日期</th>
            <th>备注</th>
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
<div class="buttom">
  <form class="form-inline" role="form">
	<div class="row">
		<button class="btn btn-default quyao" type="button" data-id="">完成</button>
	</div>
</form>
  </div>
</div>
<script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/medicine/medicineList.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{medicinName}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{count}}</td>
  <td>{{createTime}}</td>
  <td>{{remark}}</td>
 </tr>
 {{/each}}
</script>  
</body>
