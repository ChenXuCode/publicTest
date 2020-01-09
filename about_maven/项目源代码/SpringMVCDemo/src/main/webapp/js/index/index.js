
function Validate111(){
	
	if ($("#userCode").val()==""){
		alert("userCode is null");
	}
	if ($("#userPwd").val()==""){
		alert("userPwd is null");
	}
	$.ajax({
		type:"post",
		data:$("#frm_logon").serialize(),
		dataType:"json",
		url:"/SpringMVCDemo/logon.do?action=logon",
		success:function(result)
		{
			alert("ssssss");
			if(result.result=="succ")
				{
					alert(result.message);
					window.location.href="/SpringMVCDemo/logon.do?action=main&curPage=1&pageRows=10";
					return;
				}else {
					alert(result.message);
					window.location.href="/SpringMVCDemo/logon.do?action=error";
					return;
				}
		},
		error:function(result)
		{
			alert("调用Ajax不成功");
			window.location.href="/SpringMVCDemo/logon.do?action=error";
			return;
		}
		
	});
	
}