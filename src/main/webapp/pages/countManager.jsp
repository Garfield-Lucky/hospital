<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 统计汇总 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/charge/countManager.css">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<body>
<div class="query" >
 <form class="form-inline" role="form">
	<div class="row">
		<div class="col-lg-4">
			开始时间&nbsp;<input type="text" id="d421" class="form-control Wdate stime" data-stime="" onClick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" placeholder="开始时间">
		</div>
        <div class="col-lg-4">
			结束时间&nbsp;<input type="text" id="d421" class="form-control Wdate etime" data-etime="" onClick="WdatePicker({skin:'whyGreen'})" placeholder="结束时间">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4">
			收费员&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="form-control clerk" data-clerk="" placeholder="收费员">
		</div>
		<button class="btn btn-default find" type="button">查询</button>
	</div>
</form>
</div>
<div id="session">
<table class="table">
    <caption>统计汇总</caption>
    <thead>
        <tr class="headers">
            <th>收费员</th>
            <th>收费</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>明细</th>
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
<script src="js/charge/countManager.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td class="clerk">{{clerk}}</td>
  <td>{{total}}</td>
  <td class="stime">{{stime}}</td>
  <td class="etime">{{etime}}</td>
  <td><span class="glyphicon glyphicon-search detail" style="font-size: 16px;color:#3399D2;margin-left:6px;" data-name="{{clerk}}" data-stime="{{stime}}" data-etime="{{etime}}"></span></td>
 </tr>
 {{/each}}
</script>   
</body>
 