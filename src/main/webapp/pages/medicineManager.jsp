<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  藥品管理 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/medicine/medicineManager.css">
<body>
<div class="query" >
<form class="bs-example bs-example-form" role="form">
		<div class="row">
			<div class="col-lg-4">
				<div class="input-group">
					<input type="text" class="form-control medicineName" data-name="" placeholder="药品名">
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
 <table class="table">
    <caption>药品管理</caption>
    <thead>
        <tr class="headers">
            <th>药品名称</th>
            <th>供货单位</th>
            <th>规格</th>
            <th>单价</th>
            <th>库存</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="medicine_list">
        
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
<script src="js/medicine/medicineManager.js"></script>
<script id="departmentList4" type="text/x-handlebars-template">
 {{#each this}}
 <tr>
  <td>{{medicineName}}</td>
  <td>{{supplier}}</td>
  <td>{{medicineSpec}}</td>
  <td>{{price}}</td>
  <td>{{repertory}}</td>
  <td><a class="glyphicon glyphicon-edit detail" data-id={{medicineCode}}></a> <a data-id={{medicineCode}}  class="glyphicon glyphicon-trash del"></a> </td>
 </tr>
 {{/each}}
</script>   
</body>
 
 