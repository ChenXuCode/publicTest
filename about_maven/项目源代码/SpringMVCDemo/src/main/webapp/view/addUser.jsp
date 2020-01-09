<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户信息</title>
<link rel="stylesheet" type="text/css" href="css/global/base.css">
<link rel="stylesheet" type="text/css" href="css/global/table.css">
<script language="JavaScript" src="js/global/jquery.min.js"></script>
<script src="comm/artDialog4.1.7/artDialog.source.js?skin=blue"></script>
<script src="comm/artDialog4.1.7/plugins/iframeTools.source.js"></script>
<script language="JavaScript" src="js/logon/main.js"></script>
</head>
<body>
	<form id="editForm" method="post">
		<input type="hidden" name="curPage" value="${curpage}" />
		<input type="hidden" name="pageRows" value="${pageRows}" />
		<table  width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr style="height:25px">
				<td class="tabSingleHeader"  width="30%">用户代码</td>
				<td width="70%">
					<input type="text" id="userCode" name="userCode" value=""  style="width:100%" />
				</td>
			</tr>
			<tr style="height:25px">
				<td class="tabSingleHeader">用户名称</td>
				<td>
					<input type="text" id="userName" name="userName" value="" style="width:100%"/>
				</td>
			</tr>
			<tr style="height:25px">
				<td class="tabSingleHeader">用户密码</td>
				<td>
					<input type="text" id="userPwd" name="userPwd" value="" style="width:100%"/>
				</td>
			</tr>
			<tr style="height:25px">
				<td class="tabSingleHeader">联系电话</td>
				<td>
					<input type="text" id="telephone" name="telephone" value="" style="width:100%"/>
				</td>
			</tr>
			<tr style="height:25px">
				<td class="tabSingleHeader">邮箱地址</td>
				<td>
					<input type="text" id="email" name="email" value="" style="width:100%"/>
				</td>
			</tr>
			<tr style="height:25px">
				<td class="tabSingleHeader">是否有效</td>
				<td class="tdDataItem">
					<label><input type="radio" name="status" value="0" <c:if test="${status=='0' }">checked</c:if> >有效</label>
					<label><input type="radio" name="status" value="1" <c:if test="${status=='1' }">checked</c:if> >无效</label>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<button type="button" onclick="addSaveUser();" class="btn_bg">保&nbsp;&nbsp;存</button>&nbsp;
					<button type="button" onclick="javascript:art.dialog.close();" class="btn_bg">取&nbsp;&nbsp;消</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
