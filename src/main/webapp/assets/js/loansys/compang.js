var company = {};

company.dim_search = function() {
//	if($("#dim_search_value").val()==""){
//		alert("请输入查询条件");
//	}else{
		document.form.action = host + '/searchcompany';
        document.form.submit();
//	}
};
company.precise_search = function() {
	document.form.action = host + '/company';
    document.form.submit();
};
company.sure_import = function() {
	if (getsuffix($('#company_file').val()).indexOf('xlsx')>=0
			|| getsuffix($('#company_file').val()).indexOf('xls')>=0) {
		document.form.action = host + '/company/inportcompany';
		$("#form").attr('enctype', 'multipart/form-data');
	    document.form.submit();
	} else {
		alert("请选择excel文档");
		return ;
	}

	// document.form.action = host + '/company';
	// document.form.submit();
};



company.canceladd = function() {
	window.location.href = host + '/company';
};
company.toaddcom = function() {
	window.location.href = host + '/company/toaddcompany';
};
company.addcom = function() {
	var s_companyname = publictooltip($('#s_companyname'), '单位名称不可以为空');
	var s_principalname = publictooltip($('#s_principalname'), '负责人不可以为空');
	var d_totalmoney = publictooltip($('#d_totalmoney'), '集资款数量不可以为空');
	var s_address = publictooltip($('#s_address'), '地址不可以为空');
	var s_mobile = publictooltip($('#s_mobile'), '联系电话不可以为空');
	var i_gongzibanjihuashu = publictooltip($('#i_gongzibanjihuashu'),
			'公资办考核计划数不可以为空');
	var i_qiyejihuashu = publictooltip($('#i_qiyejihuashu'), '企业计划数不可以为空');
	var s_createuser = publictooltip($('#s_createuser'), '创建人不可以为空');
	var s_remark = publictooltip($('#s_remark'), '备注不可以为空');
	if (s_companyname && s_principalname && d_totalmoney && s_address
			&& s_mobile && i_gongzibanjihuashu && i_qiyejihuashu
			&& s_createuser && s_remark) {
		var sure = window.confirm('确定提交吗?');
		if (sure) {
			document.form1.submit();
		}
	}
};

function publictooltip(id, title) {
	if (id.val() == "") {
		id.attr('title', title);
		id.tooltip('show');
		return false;
	}
	return true;
}

company.toeditcom = function(id) {
	window.location.href = host + '/company/toeditcompany?id=' + id;
};
company.toedelcom = function(id) {
	var deleteensure = window.confirm('删除后不可恢复,确定删除吗？');
	if (deleteensure) {
		$.ajax({
			type : "GET",
			url : host + '/company/deletecompany',
			data : "id=" + id,
			dataType : "text",
			success : function(msg) {
				if(msg=="1"){
					alert("删除成功");
					window.location.href = host + '/company';
				}else{
					alert("删除失败");
				}
			}
		});
	}
};
company.toshowcom = function(id) {
	window.location.href = host + '/company/toshowcompany?id=' + id;
};

//---------public
function getsuffix(path_filename){
	var company_file_paths = path_filename.split('.');
	var suffix = company_file_paths[company_file_paths.length-1];
	return suffix;
}
