<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../tools/header.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("form:first").submit();
		});
		
	});
	//第一个参数：提示内容
	//第二个参数：删除的主键
	function showMsg(msg, id) {
		//top.document.getElementById("context-msg").style.display = "block";
		top.$('context-msg').style.display = "block";//把遮罩的div显示出来，开始是隐藏
		top.$('context-msg-text').innerHTML = msg;//改变遮罩div上面的文字
		top.$('hid-action').value = "${ctx}/dept/delete?dept.id="+id;//点击确认按钮，发送的url请求。应该是我们的删除请求
		top.lock.show();//隐藏遮罩div
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">部门管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="list" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68" height="30">&nbsp;&nbsp;&nbsp;</td>
						<td width="123">&nbsp;</td>
						<td width="62">部门名称:</td>
						<td width="142"><input name="deptVo.name" type="text" size="18" /></td>
						<td width="60">电话:</td>
						<td width="149"><input name="deptVo.telephone" type="text" size="18" /></td>
						<td width="70"><a id="query"> <img
								src="${ctx}/images/can_b_01.gif" border="0" />
						</a></td>
						<td width="70"><a href="input"><img
								src="${ctx}/images/can_b_02.gif" border="0" /> </a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<c:choose>
					<c:when test="${list==null}">
						<center>
							<span style="font-size:20px;color:#96D34A;font-weight:bold">没有查找到满足条件的数据！</span>
						</center>
					</c:when>
					<c:otherwise>
						<table width="100%" border="1" cellpadding="0" cellspacing="0">
							<tr align="center"
								style="background:url(${ctx}/images/table_bg.gif) repeat-x;">
								<td width="13%" height="30">编号</td>
								<td width="13%">部门名称</td>
								<td width="16%">电话</td>
								<td width="16%">操作</td>
							</tr>
							<c:forEach items="${list}" var="dept">
							<tr align="center" bgcolor="#FFFFFF">
								<td width="13%" height="30">${dept.id}</td>
								<td>${dept.name}</td>
								<td>${dept.telephone}</td>
								<td><img src="${ctx}/images/icon_3.gif" /> <span
									style="line-height:12px; text-align:center;"> <a
										href="toUpdate?dept.id=${dept.id}" class="xiu">修改</a>
								</span> <img src="${ctx}/images/icon_04.gif" /> <span
									style="line-height:12px; text-align:center;"> <a
										href="javascript:void(0)" class="xiu"
										onclick="showMsg('是否删除该项数据？当前部门删除后，所有部门内的员工将被删除，同时相关数据也将删除！',${dept.id})">删除</a>
								</span></td>
							</tr>
							</c:forEach>
						</table>
						<%@include file="../tools/paging.jsp" %>
					</c:otherwise>
				</c:choose>
			</div>
		</form>
	</div>
	<div class="content-bbg"></div>
</div>
