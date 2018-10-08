<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <style>
 
#session1{
 width: 100%;
 height:400px;
}
 .form-inline{
 margin-top:  20px;
 margin-left: 20px;
 }
.content1{
width: 1000px;
position:relative;
}
 .checkResult{
 width: 500px;
 height: 400px;
 margin-left:50px;
 margin-top:60px;
 }

.checkImage{
width: 350px;
height: 350px;
margin-left:50px;
margin-top:20px;
overflow: hidden;
}
 .patientInfo{
margin-top: 20px;
margin-left: 40px;
color: #686963;
} 
</style>
<body>
<div class="patientInfo"><span>当前患者id：${userId}</span>&nbsp;&nbsp;<span>患者姓名：${userName}</span></div>
	<div class="content1">
	   <table>
	   
	   <tr>
	      <td>
	      <div class="checkResult">
			          <textarea  class="form-control checkContent"  cols="55" rows="15" placeholder="检查结果" readonly="readonly">${checkResult}</textarea>
			</div>
			
			</td>
			 <td>
			<div class="checkImage">
			          <img src="checkImage/${checkPhoto}"></img>
			</div>
			</td>
			</tr>
		</table>
	</div>
</body>
