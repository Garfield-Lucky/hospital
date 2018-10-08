<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 
<!DOCTYPE html>
<html>
   <head>
      <title>门诊信息系统</title>
      <base href="<%=basePath%>" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--       <link rel="stylesheet" type="text/css" href="css/common/common.css"> -->
      <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
      <link rel="stylesheet" type="text/css" href="css/index/index.css">
      <link rel="stylesheet" type="text/css" href="css/user/accountManager.css">
      <link rel="stylesheet" type="text/css" href="css/charge/billManager.css">
      <link rel="stylesheet" type="text/css" href="css/charge/charge.css">
      <link rel="stylesheet" type="text/css" href="css/charge/chargeManager.css">
      <link rel="stylesheet" type="text/css" href="css/doctor/checkListShow.css">
      <link rel="stylesheet" type="text/css" href="css/doctor/checkManager.css">
      <link rel="stylesheet" type="text/css" href="css/charge/countManager.css">
      <link rel="stylesheet" type="text/css" href="css/doctor/diagnose.css">
      <link rel="stylesheet" type="text/css" href="css/user/doctorManager.css">
      <link rel="stylesheet" type="text/css" href="css/medicine/medicineImport.css">
      <link rel="stylesheet" type="text/css" href="css/medicine/medicineManager.css">
      <link rel="stylesheet" type="text/css" href="css/medicine/medicineSale.css">
      <link rel="stylesheet" type="text/css" href="css/medicine/medicineTop.css">
      <link rel="stylesheet" type="text/css" href="css/user/officeManager.css">
      <link rel="stylesheet" type="text/css" href="css/doctor/patientList.css">
      <link rel="stylesheet" type="text/css" href="css/doctor/presManager.css">
      <link rel="stylesheet" type="text/css" href="css/register/registerApply.css">
      <link rel="stylesheet" type="text/css" href="css/register/registerBack.css">
      <link rel="stylesheet" type="text/css" href="css/register/registerInfo.css">
      <link rel="stylesheet" type="text/css" href="css/register/registerManager.css">
      <link rel="stylesheet" type="text/css" href="css/user/userManager.css">
      <link rel="stylesheet" type="text/css" href="css/user/checkFeeManager.css">
      <link rel="stylesheet" type="text/css" href="css/user/doctorWorkManager.css">
      <link rel="stylesheet" type="text/css" href="css/patient/patientPress.css">
      <link rel="stylesheet" type="text/css" href="css/patient/patientDiagnose.css">
      <link rel="stylesheet" type="text/css" href="css/patient/patientCheck.css">
      <script src="js/jquery/jquery-1.9.1.min.js"></script>
      <script type="text/javascript" src="js/handlebars-v2.0.0.js"></script>
      <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
      <script src="js/index/index.js"></script>
      <link rel="stylesheet" type="text/css" href="css/common/common.css">
   </head>
   <body>
	   <div class="nav" style="background-image: url('images/nav3.gif');">
	     <img class="icon" src="images/logo2.png" title="easy首页"></img>
		  <ul class="nav_menu">
<!-- 			<li class="active"><a href="#">主页</a></li> -->
<!-- 			<li><a href="#">个性化</a></li> -->
<!-- 			<li><a href="#">公告</a></li> -->
			<li class="logout"><a title="退出系统"><span class="glyphicon glyphicon-off" style="font-size: 16px;color:#CC2921;"></span></a></li>
			<li class="loginUser" ><span class="glyphicon glyphicon-user user_icon" style="font-size: 16px;color:#3276B1;"></span><span>${userInfo.trueName}</span></li>
		</ul>
	   </div>
	   <div class="mainbody">
	      <div class="mainbody_left panel-group" id="according">
<!-- 	       使第一个模块距离顶部留点距离 -->
          <div class="Mtop one">
          </div><!-- one -->
	      <c:if test="${userInfo.userType == 3 || userInfo.userType == 1}">
	         <div class="panel panel-default">
			  <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-parent="#according" data-target="#demo1">
		                  挂号管理处  
	           </button> 
	           <br>
	           <div id="demo1" class="collapse">
		           <ul>
				        <li >
				            <a class="register_info">登记信息</a>
				        </li>
				        <li >
				            <a class="register_apply">预约挂号</a>
				        </li>
				        <li >
				            <a class="backRegister">退号管理</a>
				        </li>
				        <li >
				            <a class="count">挂号统计</a>
				        </li>
				   </ul>
	          </div>
	        </div>
	       </c:if>
	       <c:if test="${userInfo.userType == 2 || userInfo.userType == 1}">
	        <div class="panel panel-default">
	            <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo2" data-parent="#according">
		                  医生工作站   
	           </button> 
	           <br>
	           <div id="demo2" class="collapse">
		           <ul>
				        <li >
				            <a class="zhenduan">诊断管理</a>
				        </li>
				        <li >
				            <a class="chufang">处方单管理</a>
				        </li>
				        <li >
				            <a class="check">检查单管理</a>
				        </li>
				        <li >
				            <a class="diagnoseManager">诊断单管理</a>
				        </li>
				        <li >
				            <a class="patient_list">查看病人列表</a>
				        </li>
				   </ul>
	          </div>
	        </div>
	        </c:if>
	        <c:if test="${userInfo.userType == 4 || userInfo.userType == 1}">
	         <div class="panel panel-default">
	            <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo3" data-parent="#according">
		                  划价收费处
	           </button> 
	           <br>
	           <div id="demo3" class="collapse">
		           <ul>
				        <li >
				            <a class="charge">划价收费</a>
				        </li>
				        <li >
				            <a class="chargeAccount">收费结算</a>
				        </li>
				        <li >
				            <a class="billManager">账单管理</a>
				        </li>
				         <li >
				            <a class=voucherCenter>充值中心</a>
				        </li>
				         <li >
				            <a class="countGather">统计汇总</a>
				        </li>
				   </ul>
	          </div>
	          </div>
	          </c:if>
	          <c:if test="${userInfo.userType == 6 || userInfo.userType == 1}">
	           <div class="panel panel-default">
	            <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo4" data-parent="#according">
		                  检查化验室
	           </button> 
	           <br>
	           <div id="demo4" class="collapse">
		           <ul>
				        <li >
				            <a class="checkList">检验</a>
				        </li>
				         <li >
				            <a class="checkResultManager">检验单管理</a>
				        </li>
				       
				   </ul>
	          </div>
	          </div>
	          </c:if>
	          <c:if test="${userInfo.userType == 5 || userInfo.userType == 1}">
	           <div class="panel panel-default">
	            <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo5" data-parent="#according">
		                       药房管理处 
	             </button> 
	           <br>
	           <div id="demo5" class="collapse">
		           <ul>
				        <li>
				            <a class="baiyao">摆药处理</a>
				        </li>
				        <li >
				            <a class="import">入库管理</a>
				        </li>
				        <li >
				            <a class="medicineManager">药品管理</a>
				        </li>
				         <li >
				            <a class="saleTop">销售排行</a>
				        </li>
				   </ul>
	          </div>
	          </div>
	          </c:if>
	          <c:if test="${userInfo.userType == 1}">
	           <div class="panel panel-default">
	           <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo6" data-parent="#according">
		                  系统管理处 
	           </button> 
	           <br>
	           <div id="demo6" class="collapse">
		           <ul>
				        <li >
				            <a class="patientList">患者信息管理</a>
				        </li>
				        <li >
				            <a class="doctorList">医生信息管理</a>
				        </li>
				        <li >
				            <a class="doctorWork">值班安排管理</a>
				        </li>
				        <li >
				            <a class="checkFee">检查费用管理</a>
				        </li>
				        <li >
				            <a class="officeManager">科室信息管理</a>
				        </li>
				         <li >
				            <a class="userManager">用户信息管理</a>
				        </li>
				   </ul>
	          </div>
	          </div>
	          </c:if>
	          <c:if test="${userInfo.userType == 0 || userInfo.userType == 1}">
	           <div class="panel panel-default">
	          <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo7" data-parent="#according">
		                  用户中心 
	           </button> 
	           <br>
	           <div id="demo7" class="collapse">
		           <ul>
				        <li >
				            <a class="findDiagnose">病历单查询</a>
				        </li>
				        <li >
				            <a class="findPres">处方单查询</a>
				        </li>
				        <li >
				            <a class="findCheck">检查单查询</a>
				        </li>
				        <li >
				            <a class="registerInline">在线预约挂号</a>
				        </li>
				   </ul>
	          </div>
	      </div>
	      </c:if>
	      <div class="panel panel-default">
	          <button  class="btn btn-primary location" data-toggle="collapse" 
			     data-target="#demo8" data-parent="#according">
		                  个人中心 
	           </button> 
	           <br>
	           <div id="demo8" class="collapse">
		           <ul>
		            <c:if test="${userInfo.userType == 0}">
		                <li >
				            <a class="personInfo">个人信息</a>
				        </li>
				    </c:if>
				        <li >
				            <a class="accountManager">修改密码</a>
				        </li>
				   </ul>
	          </div>
	      </div>
	      </div>
	      <div class="mainbody_right">
	      
	      </div>
	  </div>
      
   </body>
</html>
