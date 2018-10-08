<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!--  预约挂号 -->
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/patient/registerApply.css">
<body>
<div class="query" >
 <form class="form-inline registerApply" role="form">
	<div class="row">
		<div class="col-lg-4">
			科室名称&nbsp;<input type="text" class="form-control officeType" data-type="" placeholder="科室名称">
		</div>
        <div class="col-lg-4">
			医生姓名&nbsp;<input type="text" class="form-control doctorName" data-name="" placeholder="医生姓名">
		</div>
		<button class="btn btn-default find" type="button">查找</button>
	</div>
</form>
</div>
<div id="session1">
 <table class="table">
  <caption>预约挂号</caption>
    <thead>
        <tr class="headers">
            <th>医生</th>
            <th>科室</th>
            <th>职称</th>
            <th>值班时间</th>
            <th>门诊类型</th>
            <th>剩余号数</th>
            <th>挂号费</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="register_list">
        
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
<!-- 蒙版 -->
<div class="mask"></div>

     <div class="registerPage registerInto"  data-id='${userinfo.id}' style="top: 316.5px;">
       <h3>预约挂号</h3><span class="close">×</span>
       <div class="payType">
              <span>支付方式：
                  <input type="radio" name="payType" value="0" class="marry" checked="checked">账户余额
			      <input type="radio" name="payType" value="1" class="marry">支付宝
              </span>
       </div>
       <div class="yuyue"><span class="cancel">取消</span><span class="ok">预约</span></div>
     </div>
     
</div>
 <script src="js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
<script src="js/patient/registerApply.js"></script>
<script src="js/liClick.js"></script>
 <script id="departmentList4" type="text/x-handlebars-template">
{{#each this}}
 <tr>
  <td>{{doctorName}}</td>
  <td>{{officeType}}</td>
  <td>{{title}}</td>
  <td>{{workDate}}</td>
  <td>{{clinicType}}</td>
  <td>{{reaminCount}}</td>
  <td>{{registerFee}}</td>
  <td><span data-code={{doctorCode}}   data-date={{trueDate}} data-office={{officeCode}} class="register">预约</span> </td>
 </tr>
 {{/each}}
</script>  
</body>
