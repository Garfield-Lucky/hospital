<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  划价收费 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/charge/charge.css">
<body>
<div class="query" >
<form class="bs-example bs-example-form" role="form">
		<div class="row">
			<div class="col-lg-4">
				<div class="input-group">
					<input type="text" class="form-control vistId" data-vistId="" placeholder="挂号序号">
					<span class="input-group-btn">
						<button class="btn btn-default find" type="button">
							查询
						</button>
					</span>
				</div>
			</div>
		</div>
	</form>
</div>
<div id="session1">
 <table class="table" >
    <caption>收费列表</caption>
    <thead>
        <tr class="headers">
            <th>挂号序号</th>
            <th>姓名</th>
            <th>收费项目</th>
            <th>规格</th>
            <th>数量</th>
            <th>单价</th>
            <th>合计</th>
        </tr>
    </thead>
    <tbody id="charge_list">
        
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
        <div class="col-lg-3">
			合计&nbsp;<input type="text"  class="form-control allFee" readonly="readonly" >
		    <span class="selectPay">    
		          支付类型&nbsp;&nbsp;<input type="radio" name="pay" value="0" class="cash" checked="checked">现金
			        <input type="radio" name="pay" value="1" class="account">个人账户</span> 
			<button class="btn btn-default huajia" type="button" data-id="">划价</button>
		</div>
	</div>
	<div class="row">
        <div class="col-lg-3">
        <span class="yue" style="opacity:0;">
			余额&nbsp;<input type="text" value="0.0" class="form-control balance" readonly="readonly"></span>
		</div>
	</div>
   </form>
  </div>
</div>
  <script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/charge/charge.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{vistId}}</td>
  <td>{{userName}}</td>
  <td>{{chargeItem}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{count}}</td>
  <td>{{price}}</td>
  <td>{{itemCount}}</td>
 </tr>
 {{/each}}
</script>   
</body>
 
 