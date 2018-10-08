<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 销售排行  -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/medicine/medicineTop.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/echarts/echarts.min.js"></script>
<body>
<div class="query" >
<form class="form-inline medicineTop" role="form">
	<div class="row">
		<div class="col-lg-3">
			开始时间&nbsp;<input type="text" id="d421" class="form-control Wdate stime" data-stime="" onClick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" placeholder="开始时间">
		</div>
        <div class="col-lg-3">
			结束时间&nbsp;<input type="text" id="d421" class="form-control Wdate etime" data-etime=""  onClick="WdatePicker({skin:'whyGreen'})" placeholder="结束时间">
		</div>
		<button class="btn btn-default find" type="button">查询</button>
		<button class="btn btn-default change" data-id="0" type="button">转换</button>
	</div>
	</form>
</div>
<div id="session1">
 <table class="table">
    <caption>销售排行</caption>
    <thead>
        <tr class="headers">
            <th>药品名称</th>
            <th>供货单位</th>
            <th>规格</th>
            <th>单价</th>
            <th>库存</th>
            <th>销量</th>
        </tr>
    </thead>
    <tbody id="top_list">
         
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
 <div id="main_top"></div>
</div>
  <script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/medicine/medicineTop.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{medicineName}}</td>
  <td>{{supplier}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{price}}</td>
  <td>{{repertory}}</td>
  <td>{{sales}}</td>
 </tr>
 {{/each}}
</script>
 
</body>
 
 