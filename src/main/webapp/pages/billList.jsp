<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  账单管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/charge/billList.css">
<body>
<div id="session1">
<table class="table" data-stime="${stime}" data-etime="${etime}" data-name="${clerk}">
    <caption>账单明细</caption>
    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>收费员</th>
            <th>姓名</th>
            <th>收费项目</th>
            <th>规格</th>
            <th>数量</th>
            <th>单价</th>
            <th>合计</th>
            <th>创建日期</th>
        </tr>
    </thead>
    <tbody id="bill_list">
        
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
<script src="js/charge/billList.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{clerk}}</td>
  <td>{{userName}}</td>
  <td>{{chargeItem}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{count}}</td>
  <td>{{price}}</td>
  <td>{{itemCount}}</td>
  <td>{{createTime}}</td>
 </tr>
 {{/each}}
</script> 
</body>
 