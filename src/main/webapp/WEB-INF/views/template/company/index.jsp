<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="company" method="post" name="form" id="form">
	<fieldset>
		<legend>查询单位</legend>
		查询条件<input type="text" placeholder="查询条件" name="dim_search_value"
			id="dim_search_value" value="${dim_search_value}">
		<button type="button" class="btn btn-mini" id="dim_search">查询</button>
		<button type="button" class="btn btn-mini" data-toggle="modal" data-target="#myModal" >精确查询</button>

		<button type="button" class="btn btn-mini" id="toaddcom">新增</button>
		<button type="button" class="btn btn-mini" data-toggle="modal" data-target="#myModalimportcompany">导入</button>
		<button type="button" class="btn btn-mini" id="exportcompany" >导出</button>
		<legend></legend>
		<table class="table table-bordered">
			<tr class="warning">
				<td>编号</td>
				<td>单位名称</td>
				<td>地址</td>
				<td>负责人</td>
				<td>联系电话</td>
				<td width="20%">备注</td>
				<td width="15%">操作</td>
			</tr>
			<c:forEach items="${companys}" var="company" varStatus="status">
				<c:if test="${status.index%2==0}">
					<tr>
				</c:if>
				<c:if test="${status.index%2==1}">
					<tr class="success">
				</c:if>
				<td>${company.s_NO}</td>
				<td>${company.s_companyname}</td>
				<td>${company.s_address}</td>
				<td>${company.s_principalname}</td>
				<td>${company.s_mobile}</td>
				<td>${company.s_remark}</td>
				<td>
					<button type="button" class="btn-mini"
						onclick="company.toshowcom(${company.id})">查看</button>
					<button type="button" class="btn-mini"
						onclick="company.toeditcom(${company.id})">编辑</button>
					<button type="button" class="btn-mini btn-danger"
						onclick="company.toedelcom(${company.id})">删除</button>
				</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"><ul class="pagination">
						<li class="disabled"><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li class="active"><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul></td>
			</tr>
		</table>
	</fieldset>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">精确查找</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered">
						<tr>
							<td>编号</td>
							<td><input type="text" placeholder="编号" name="s_NO" value="${company.s_NO}"/></td>
						</tr>
						<tr>
							<td>单位名称</td>
							<td><input type="text" placeholder="单位名称" name="s_companyname" value="${company.s_companyname}"/></td>
						</tr>
						<tr>
							<td>负责人</td>
							<td><input type="text" placeholder="负责人" name="s_principalname" value="${company.s_principalname}"/></td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input type="text" placeholder="联系电话" name="s_mobile" value="${company.s_mobile}"/></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input type="text" placeholder="地址" name="s_remark" value="${company.s_remark}" /></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="precise_search">确定查找</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModalimportcompany" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">导入单位</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered">
						<tr>
							<td>请选择一个文件</td>
							<td></td>
						</tr>
						<tr>
							<td><input name="myfiles" type="file" id="company_file"/> </td>
							<td></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="sureimport"
					data-dismiss="modal"
					data-toggle="modal" data-target="#progress">确定导入</button>
				</div>
			</div>
		</div>
	</div>
</form>


<script type="text/javascript">
$(function(){
	$('#toaddcom').click(company.toaddcom);
	$('#dim_search').click(company.dim_search);
	$('#precise_search').click(company.precise_search);
	$('#sureimport').click(company.sure_import);//导入操作
// 	$('#emportcompany').click(company.emportcompany);
	
});

</script>