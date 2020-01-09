function btnQuery(pagePerRows) {
	queryForm.action = "item.do?action=findMutiCondition&curPage=1&pageRows="+ pagePerRows;
	queryForm.submit();    
}

function funAdd() {
	alert('item.js funAdd()');
	art.dialog.open('item.do?action=basItemAdd', {
		id : 'memdiv',
		width : 570,
		height : 260,
		title : '新增物料'
	});
}


function submitRegistFormItem() {
	$.ajax({
		type : "POST",
		data : $('#frmServRegist').serialize(),
		dataType : "json",
		url : "item.do?action=saveAddItem",
		success : function(result) {
			if (result.result == "succ") {
				art.dialog({
					content : '新增物料成功',
					id : 'EF893L',
					title : '成功',
					icon : 'succeed'
				});
				// 刷新父页面
				var win = art.dialog.open.origin;
				win.location.reload();
				return false;
			} else {
				art.dialog({
					content : '新增物料失败',
					id : 'EF893L',
					title : '错误',
					icon : 'error'
				});
			}
		},
		error : function(result) {
			art.dialog({
				content : '新增物料失败',
				id : 'EF893L',
				title : '错误提示',
				icon : 'error'
			});
		}
	});
}


function funEdit(curPage, pageRows) {
	var strChoseUserId=$('input:radio[name="itemcheck"]:checked').val(); 
	if (strChoseUserId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
		alert(strChoseUserId);
			art.dialog.data('curPage', curPage);
			art.dialog.data('pageRows', pageRows);
			art.dialog.data('ItemId', strChoseUserId);
			art.dialog.open('item.do?action=ItemEdit&ItemId=' + strChoseUserId, {
				id : 'memdiv',
				width : 570,
				height : 260,
				title : '编辑物料'
			});
	}
}


function funEditItem(){
	$.ajax({
		type : "POST",
		data : $('#frmServRegist').serialize(),
		dataType : "json",
		url :"item.do?action=editSaveItem",
		success : function(result) {
  			if(result.result=="succ"){
  				art.dialog({
				    content: '编辑物料成功',
				    id: 'EF893L',
				    title: '成功',
				    icon: 'succeed'
				});
  			    //刷新父页面
  				var win = art.dialog.open.origin;
  				win.location.reload();
  				return false;
  			}else{
  				art.dialog({
				    content: '编辑物料失败',
				    id: 'EF893L',
				    title: '错误',
				    icon: 'error'
				});
  			}       	  			
		},
		error : function(result) {
			art.dialog({
			    content: '编辑物料失败',
			    id: 'EF893L',
			    title: '错误提示',
			    icon: 'error'
			});
		}
});	
}

function fundel(curPage, pageRows) {
	var strChoseItemId=$('input:radio[name="itemcheck"]:checked').val(); 
	alert(strChoseItemId);
	if (strChoseItemId == null) {
		art.dialog({
			content : "<span style='font-size:12px'>请选择记录！</span>",
			title : "提示",
			cancelVal : '关闭',
			icon : 'warning'
		});
	} else {
		$.ajax({
			type : "POST",
			data : "ItemCode=" + strChoseItemId,
			dataType : "json",
			url : "item.do?action=deleteItem",
			success : function(result) {
				if (result.result == "succ") {
					// 刷新父页面
					var win = art.dialog.open.origin;
					win.location.reload();
					return false;
				} else {
					art.dialog({
						content : '删除物料失败',
						id : 'EF893L',
						title : '错误',
						icon : 'error'
					});
				}
			},
			error : function(result) {
				art.dialog({
					content : '删除物料失败',
					id : 'EF893L',
					title : '错误提示',
					icon : 'error'
				});
			}
		});
	}
}