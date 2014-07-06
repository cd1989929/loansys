<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="backmethod" class="com.sds.loansys.controller.BackMethod" scope="page" />
<form>
	<fieldset>
		<table class="table table-bordered">
			<tr >
				<td colspan="6">单位信息——${company.s_companyname}</td>
			</tr>
			<tr>
				<td class="warning">编号</td>
				<td>${company.s_NO}</td>
				<td class="warning">单位名称</td>
				<td>${company.s_companyname}</td>
				<td class="warning">负责人</td>
				<td>${company.s_principalname}</td>
			</tr>
			<tr>
				<td class="warning">集资款数量</td>
				<td>${backmethod.parseDB2DOUBLE(company.d_totalmoney)}</td>
				<td class="warning">地址</td>
				<td>${company.s_address}</td>
				<td class="warning">联系电话</td>
				<td>${company.s_mobile}</td>
			</tr>
			<tr>
				<td class="warning">公资办考核计划数</td>
				<td>${company.i_gongzibanjihuashu}</td>
				<td class="warning">企业计划数</td>
				<td>${company.i_qiyejihuashu}</td>
				<td class="warning">创建人</td>
				<td>${company.s_createuser}</td>
			</tr>
			<tr>
				<td class="warning">备注</td>
				<td>${company.s_remark}</td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td colspan="6"><button type="button" class="btn" onclick="history.go(-1)">返回</button></td>
			</tr>
		</table>
	</fieldset>
</form>
<script type="text/javascript">
$(function(){
	$('#cancel').click(company.canceladd);
});
</script>