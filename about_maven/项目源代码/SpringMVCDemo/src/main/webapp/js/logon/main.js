function btnQuery(pagePerRows)
{
	queryForm.action="/SpringMVCDemo/logon.do?action=findMutiCondition&curPage=1&pageRows="+pagePerRows;
	queryForm.submit();

}

function tipAlert(tipIcon,tiptitle,msg)
{
	art.dialog({
		content:"<span style='font-size:12px'>"+msg+"</span>",
		title:tiptitle,
		icon:tipIcon
	});
}


function addUser(pageCurrent,pagePerRows)
{
	alert("添加");
	art.dialog.open("/SpringMVCDemo/logon.do?action=addUser&curpage="+pageCurrent+"&pageRows="+pagePerRows,
	{
		id:'memdiv1',
		width:370,
		height:200,
		title:'新增用户',
		close:function()
		{
			//刷新页面
			//var win=art.dialog.open.origin;
			//win.location.reload();
			//return false;
		}
	});
}


//保存新增用户信息
function addSaveUser()
{
	$.ajax({
		type:"POST",
		data:$('#editForm').serialize(),
		dataType:"json",
		url:"/SpringMVCDemo/logon.do?action=addUserSave",
		success:function(r){
			if(r.result=="succ")
			{
				//刷新页面
				var win=art.dialog.open.origin;
				win.location.reload();
				return false;
			}else{
				tipAlert('error','提示','新增用户失败1');
			}
		},
		error:function(result)
		{
			tipAlert('error','提示','新增用户失败2')
		}
	});
}


//全选
function selectAll(obj)
{
	if(obj.checked==true)
	{
		$("input[name$='uuid']").prop('checked',true);
	}else{
		$("input[name$='uuid']").prop('checked',false);
	}
}


function editUser(pageCurrent,pagePerRows)
{
	var chks=$("input[name$='uuid']:checked");
	if(chks.length==0)
	{
		tipAlert('warning','提示','请选择一笔记录!');
	}else{
		if(chks.length==1)
		{
			var uuId=chks[0].value;
			art.dialog.open("/SpringMVCDemo/logon.do?action=editUser&uuId="+uuId+"&curPage="+pageCurrent+"&pageRows="+pagePerRows,
			{
				id:'memdiv1',
				width:370,
				height:200,
				title:'编辑用户',
				close:function(){
					
				}
			});
		}else{
			tipAlert:('warning','提示','一次只能编辑一条记录');
		}
	}
}


//编辑用户
function  editSaveUser()
{
	$.ajax({
		type:"POST",
		data:$('#editForm').serialize(),
		dataType:"json",
		url:"/SpringMVCDemo/logon.do?action=editSaveUser",
		success:function(result)
		{
			if(result.result=="succ")
			{
				//刷新页面 
				var win=art.dialog.open.origin;
				win.location.reload();
				return false;
			}else{
				tipAlert('error','提示','编辑用户失败1');
			}
		},
		error:function(result)
		{
			tipAlert('error','提示','编辑用户失败2');
		}
	});
}

//删除用户
function delUser(pageCurrent,pagePerRows)
{
	var dels="";
	var chks=$("input[name$='uuid']:checked");
	var len=chks.length;
//	var pageCurrent=1;
//	var pagePerRows=10;
	for(var i=0;i<len;i++)
	{
		dels=dels+chks[i].value+",";
	}
	if(dels!="")
	{
		art.dialog({
			content:"<span style='font=size:12px;'>真要删除选中用户吗</span>",
			ok:function(){
				document.location.href="/SpringMVCDemo/logon.do?action=delUser&uuIds="+dels+"&curPage="+pageCurrent+"&pageRows="+pagePerRows;
//				window.location.href="/SpringMVCDemo/logon.do?action=main&curPage=1&pageRows=10";
			},
			cancelVal:'关闭',
			cancel:true,
			icon:'question',
			title:"询问"
		});
	}else{
		alert("shan");
		tipAlert('warning','提示','请选择删除记录');
	}
}