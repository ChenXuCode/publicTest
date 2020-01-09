<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户信息</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/bgrow.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/tools.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/page.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/biz/basic/item.js"></script>
</head>
<body>
<div id="title"> 
   <img src="/SpringMVCMybatisDemo/images/portal/pageicon.jpg" align="middle"/>
   <span id="tname">测试页面</span>
 </div>
 <div id="querybar">
   <table  cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td style="padding-left:10px;" width="70px;">
        <img src="/SpringMVCMybatisDemo/images/global/query.png" width="60px" height="60px"/>
      </td>
    <td>
    <form  id="queryForm"  method="post">
      <table cellpadding="0" cellspacing="0" width="100%">
	     <tr>
		      <td width="25%"><span id="label">编码:</span><input type="text" name="itemCode" value="${item.itemCode}"/></td>
		      <td width="25%"><span id="label">名称:</span><input type="text" name="itemName" value="${item.itemName}"/></td>
		      <td width="50%" rowspan="2">
		        <a onclick="btnQuery(${page.pagePerRows})" style="cursor:hand;"><img src="/SpringMVCMybatisDemo/images/global/btnQuery.jpg"/></a>
		      </td>
	     </tr>
	      <tr>
		      <td><span id="label">规格:</span><input type="text" name="itemSpec" value="${item.itemSpec}"/></td>
		      <td><span id="label">状态:</span>
		      <input type="radio" name="useFlag" value="-2" ${item.useFlag==-2?"checked":"" }/><span id="label">全部</span>
		      <input type="radio" name="useFlag" value="0"  ${item.useFlag==0?"checked":"" }/><span id="label">启用</span>
		      <input type="radio" name="useFlag" value="1"  ${item.useFlag==1?"checked":"" }/><span id="label">停止</span>
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
      <li><a onclick="funAdd()"><img src="/SpringMVCMybatisDemo/images/global/btnNew.jpg" align="middle"/></a></li>
      <li><a onclick="funEdit(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnEdit.jpg" align="middle"/></a></li>
      <li><a onclick="fundel(${page.pageCurrent},${page.pagePerRows})"><img src="/SpringMVCMybatisDemo/images/global/btnDel.jpg" align="middle"/></a></li>
    </ul>
    </div>
	<table class="table">
		<thead>
			<tr>
				<td width="14%" class="tabSingleHeader">学号</td>
				<td width="14%" class="tabSingleHeader">姓名</td>
				<td width="14%" class="tabSingleHeader">性别</td>
				<td width="14%" class="tabSingleHeader">专业</td>
				<td width="14%" class="tabSingleHeader">系别</td>
				<td width="14%" class="tabSingleHeader">宿舍楼号</td>
				<td width="14%" class="tabSingleHeader">宿舍号</td>
			</tr>
		</thead>
		<tbody>
<%-- 			<c:forEach items="${stulist}" var="item" varStatus="status">
			  <tr onclick="selRadioByTr(this,'itemcheck')" class="${status.count%2!=0?'tr1':'tr2'}" >
				<td align="center"><input name="itemcheck" type="radio" value="${item.itemId}" /></td>
				<td align="center">${stulist}</td>
				<td align="center">${stulist}</td>
				<td align="center">${stulist}</td>
				<td align="center">${stulist}</td>
				<td align="center">${stulist}</td>
				<td align="center">${stulist}</td>
				<td align="center">${stulist}</td>
			  </tr>
			</c:forEach> --%>
		</tbody>
		
	</table>
	<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/toolInit.js"></script>
</body>
</html>
