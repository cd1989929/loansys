<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="backmethod"
	class="com.sds.loansys.controller.BackMethod" scope="page" />
<c:if test="${company==null||company.id==0}">
	<form action="addcompany" id="form1" name="form1" method="post">
</c:if>
<c:if test="${company.id>0}">
	<form action="editcompany" id="form1" name="form1" method="post">
</c:if>
<fieldset>
	<table class="table table-bordered">
		<tr>
			<td colspan="6"><c:if test="${company.id>0}">编辑</c:if> <c:if
					test="${company==null||company.id==0}">新增</c:if>单位信息</td>
		</tr>
		<tr>
			<td class="warning">编号</td>
			<td><input type="text" name="s_NO" class="input-small"
				placeholder="编号" value="${company.s_NO}"></td>
			<td class="warning">单位名称</td>
			<td><input type="text" class="input-small" placeholder="单位名称"
				id="s_companyname" name="s_companyname" data-placement="right"
				title="单位名称" data-toggle="tooltip" value="${company.s_companyname}"></td>
			<td class="warning">负责人</td>
			<td><input type="text" class="input-small" placeholder="负责人"
				id="s_principalname" name="s_principalname" data-placement="right"
				value="${company.s_principalname}"></td>
		</tr>
		<tr>
			<td class="warning">集资款数量</td>
			<td><input type="text" class="input-small" placeholder="集资款数量"
				id="d_totalmoney" name="d_totalmoney" data-placement="right"
				value="${backmethod.parseDB2DOUBLE(company.d_totalmoney)}"></td>
			<td class="warning">地址</td>
			<td><input type="text" class="input-small" placeholder="地址"
				id="s_address" name="s_address" data-placement="right"
				value="${company.s_address}"></td>
			<td class="warning">联系电话</td>
			<td><input type="text" class="input-small" placeholder="联系电话"
				id="s_mobile" name="s_mobile" data-placement="right"
				value="${company.s_mobile}"></td>
		</tr>
		<tr>
			<td class="warning">公资办考核计划数</td>
			<td><input type="text" class="input-small"
				placeholder="公资办考核计划数" id="i_gongzibanjihuashu"
				name="i_gongzibanjihuashu" data-placement="right"
				value="${company.i_gongzibanjihuashu}"></td>
			<td class="warning">企业计划数</td>
			<td><input type="text" class="input-small" placeholder="企业计划数"
				id="i_qiyejihuashu" name="i_qiyejihuashu" data-placement="right"
				value="${company.i_qiyejihuashu}"></td>
			<td class="warning">创建人</td>
			<td><input type="text" class="input-small" placeholder="创建人"
				id="s_createuser" name="s_createuser" data-placement="right"
				value="${company.s_createuser}"></td>
		</tr>
		<tr>
			<td class="warning">备注</td>
			<td><textarea rows="3" cols="20" placeholder="备注" id="s_remark"
					name="s_remark" data-placement="right"></textarea>
					<input id="s_remark_t" type="hidden" value="${company.s_remark}"/> </td>
			<td colspan="4"></td>
		</tr>
		<tr>
			<td colspan="6"><button type="button" class="btn btn-primary"
					id="btnaddcompany">提交</button>
				<button type="button" class="btn btn-warning" id="cancel">取消</button></td>
		</tr>
	</table>
</fieldset>
</form>
<script type="text/javascript">
	$(function() {
		$('#cancel').click(company.canceladd);
		$('#btnaddcompany').click(company.addcom);
		<c:if test="${company.id>0}">
		$('#s_remark').val($('#s_remark_t').val());
		</c:if>
	});
</script>