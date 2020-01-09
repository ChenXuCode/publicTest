<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>物资信息</title>
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/base.css">
<link rel="stylesheet" type="text/css" href="/SpringMVCMybatisDemo/css/global/table.css">
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="/SpringMVCMybatisDemo/comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="/SpringMVCMybatisDemo/js/global/jquery.min.js"></script>

<script language="JavaScript" src="/SpringMVCMybatisDemo/js/biz/basic/item.js"></script>
<!-- <script language="JavaScript" src="/SpringMVCMybatisDemo/js/biz/basic/item.js"></script> -->
</head>
<body>
	<form id="frmServRegist" method="post">
	<table  width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="tabSingleHeader">序号</td>
			<td style="font-size:12px;">
			  <input type="text"  readonly  unselectable="on" name="itemId" value="${item.itemId}"  style="width:192px"/>
			</td>
		</tr>
		<tr>
			<td width="10%"  class="tabSingleHeader">编码</td>
			<td width="25%"><input type="text" name="itemCode" value="${item.itemCode}" style="width:192px;background:#F5F5F5;"/></td>
			<td width="13%" align="center"><img src="/SpringMVCMybatisDemo/images/global/find3.gif" style="cursor:hand;"/></td>
		</tr>
		<tr>
			<td class="tabSingleHeader">物资名称</td>
			<td style="font-size:12px;">
			  <input type="text" name="itemName" value="${item.itemName}"  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">计量单位</td>
			<td style="font-size:12px;"><input type="text" name="itemUnit" value="${item.itemUnit}"  style="width:192px"/></td>
		</tr>
		<tr>
			<td class="tabSingleHeader">型号规格</td>
			<td style="font-size:12px;">
			  <input type="text" name="itemSpec" value="${item.itemSpec}"  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">使用状态</td>
			<td style="font-size:12px;">
			   <input type="radio" name="useFlag" value="0" checked/>启动
			   <input type="radio" name="useFlag" value="1"/>停止
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">物料图号</td>
			<td style="font-size:12px;">
			     <input type="text" name="itemDrawNo" value="${item.itemDrawNo}"  style="width:192px"/>
			</td>
			<td class="tabSingleHeader">物料单重</td>
			<td>
			   <input type="text" name="itemWeight" value="${item.itemWeight}"  style="width:192px"/>
			</td>
		</tr>
		<tr>
			<td class="tabSingleHeader">备注</td>
			<td colspan="3">
			     <input type="text" name="itemDescription" value="${item.itemDescription}"  style="width:470px"/>
			</td>
		</tr>
	</table>
	 <center style="padding-top:5px;">
	    <button class="btn_bg" type="button" onclick='fundel()'>修&nbsp;&nbsp;改</button>	
	 </center>
	 </form>
</body>
</html>