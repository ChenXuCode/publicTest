<%@  page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<script type="text/javascript" src="js/global/jquery.min.js"></script>
<script type="text/javascript" src="js/index/index.js"></script>

<title style="font-family:STXingkai;">Java000项目实践测试</title>
</head>
<body>
   <div style="height:150px">
   </div>
   <form id="frm_logon"  method="post" >
   <div style="height:400px">
      <div>          
          <table width="419px;" border="0" cellspacing="0" cellpadding="0" align="center">
              <tr style="height:8px;">
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
              </tr>
              <tr style="height:50px;">
                <td ></td>
                <td >用&nbsp;&nbsp;&nbsp;&nbsp;户:</td>
                <td  colspan="2"><input type="text" name="userCode" id="userCode" value="sys" /></td>
                <td ></td>
                <td></td>
              </tr>
              <tr style="height:50px;">
                <td ></td>
                <td >密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                <td  colspan="2"><input type="text" name="userPwd" id="userPwd" value="123" /></td>
                <td ></td>
                <td></td>
              </tr>
              <tr style="height:50px;" >   
                <td align="center" colspan="3" rowspan="2"><input type="button" value="登陆" onClick="Validate111()"/></td>
              </tr>           
            </table>           
      </div>
   </div>
   </form>
   <div>
      <div id="copyright">
        <span style="line-height:100%;">Copyright &copy; 2015 - 2018 www.songshan.com.cn All rights reserved</span><br>
        <span style="line-height:100%;">Technical telephone: 0751-8936605</span>
      </div>
   </div>
</body>

</html>
