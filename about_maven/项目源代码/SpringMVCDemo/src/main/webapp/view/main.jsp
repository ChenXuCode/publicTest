<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户信息</title>
<script src="comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/global/table.css">
<script language="JavaScript" src="js/global/bgrow.js"></script>
<script language="JavaScript" src="js/global/jquery.min.js"></script>
<script language="JavaScript" src="js/global/page.js"></script>
<script language="JavaScript" src="js/logon/main.js"></script>
</head>
<body>
<div id="title"> 
	<img src="images/portal/pageicon.jpg" align="middle"/>
	<span id="tname">用户信息</span>
</div>
 <div id="querybar">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
		  <td style="padding-left:10px;" width="70px;"><img src="images/global/query.png" width="60px" height="60px"/></td>
		  <td>
		     <form method="post" id="queryForm">	
			 <table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td width="30%">
					    <span id="label">用户代码:</span>
					    <input type="text" name="userCode" value="${user.userCode}"  style="width:150px;"/>
					</td>
					
					<td width="70%" rowspan="2">
					    <a href="javascript:btnQuery(${page.pagePerRows});"><img src="images/global/btnQuery.jpg"  style="border: 0px;"/></a>
					</td>
				</tr>
				<tr>
				  <td>
					    <span id="label">用户名称:</span>
					    <input type="text" name="userName" value="${user.userName}"  style="width:150px;"/>
					</td>
				</tr>
			</table>
			 </form>
		  </td>
	    </tr>
	</table>
 
</div>
<div id="btnlist">
  <ul>
    <li><a onclick="addUser(${page.pageCurrent},${page.pagePerRows});"><img src="images/global/btnNew.jpg" align="middle" style="border:0px;"/></a></li>
    <li><a onclick="editUser(${page.pageCurrent},${page.pagePerRows});"><img src="images/global/btnEdit.jpg" align="middle" style="border:0px;"/></a></li>
    <li><a onclick="delUser(${page.pageCurrent},${page.pagePerRows});"><img src="images/global/btnDel.jpg" align="middle" style="border:0px;"/></a></li>
  </ul>
</div>
<table class="table" cellpadding="0" cellspacing="0" width="100%">
	<tr class="table_top" style="height:25px">
		<td class="tabSingleHeader" style="width:5%;"><input type="checkbox" onclick="selectAll(this)" name="all" style="cursor:hand"/></td>
		<td class="tabSingleHeader" style="width:15%;">用户代码</td>
		<td class="tabSingleHeader" style="width:15%;">用户名称</td>
		<td class="tabSingleHeader" style="width:15%;">用户电话</td>
		<td class="tabSingleHeader" style="width:15%;">用户邮箱</td>
		<td class="tabSingleHeader" style="width:15%;">创建人</td>
		<td class="tabSingleHeader" style="width:15%;">创建时间</td>
	</tr>
	<c:forEach items="${page.pageResult}" var="user" varStatus="status">
		<tr onmouseover="rowmouseover(this);"
		   <c:if test="${status.count%2!=0}">class="tr1" onmouseout="rowmouseout(this,'tr1')"</c:if>
		   <c:if test="${status.count%2==0}">class="tr2" onmouseout="rowmouseout(this,'tr2')"</c:if>>
		  	<td align="center"><input type="checkbox" name="uuid" value="${user.userId}"/></td>
		  	<td align="left">${user.userCode}</td>
		  	<td align="left">${user.userName}</td>
		  	<td align="left">${user.telephone}</td>
		  	<td align="left">${user.email}</td>
		  	<td align="left">${user.createUser}</td>
		  	<td align="center">${user.createDate}</td>
		 </tr>
	</c:forEach>
	<tr>
		<td class="tabFootBg" colspan="7">
			<input type="hidden" id="page_per_num" value="${page.pagePerRows}"/>
			<span style="margin-right:20px;">共有&nbsp;&nbsp;<font color="red">${page.totalRowsCount}&nbsp;</font>&nbsp;&nbsp;条信息，每页&nbsp;&nbsp;<font color="red">${page.pagePerRows}</font>&nbsp;&nbsp;条，当前&nbsp;&nbsp;<font color="red">${page.pageCurrent}&nbsp;/&nbsp;${page.totalPageCount}</font>&nbsp;&nbsp;页</span>
			<span style="padding-right:30px;">
			      <img style="cursor:hand;margin-right:10px;" src="images/global/first.gif" onclick="navigationPage('${page.url}',${page.topPageNo},'queryForm')" title="第一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="images/global/prev.gif" onclick="navigationPage('${page.url}',${page.previousPageNo},'queryForm')"  title="上一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="images/global/next.gif" onclick="navigationPage('${page.url}',${page.nextPageNo},'queryForm')"  title="下一页"/>
	              <img style="cursor:hand;margin-right:10px;" src="images/global/last.gif" onclick="navigationPage('${page.url}',${page.bottomPageNo},'queryForm')"  title="最后页"/>
	         </span>
		</td>			
	</tr>
</table>	
</body>
</html>
