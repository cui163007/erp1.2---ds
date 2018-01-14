<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<input type="hidden" name="pageNo" value="${pageNo}">
	<tr>
		<td width="51%">&nbsp;</td>
		<td width="13%">共${totalCount}条记录
		<td width="6%"><a id="fir" href="#" class="sye">首&nbsp;&nbsp;页</a></td>
		<td width="6%"><a id="pre" href="#" class="sye">上一页</a></td>
		<td width="6%"><a id="next" href="#" class="sye">下一页</a></td>
		<td width="6%"><a id="last" href="#" class="sye">末&nbsp;&nbsp;页</a>
		</td>
		<td width="12%">当前第<span style="color:red;">${pageNo}</span>/${pageCount}页
		</td>
	</tr>
</table>
<script>
	$(function(){
		//控制分页按钮是否显示
		if(${pageCount}==1){
			//就一页，按钮全部隐藏
			$("#fir").css("display","none");
			$("#pre").css("display","none");
			$("#next").css("display","none");
			$("#last").css("display","none");
		}else if(${pageNo}==1){
			$("#fir").css("display","none");
			$("#pre").css("display","none");
			$("#next").css("display","block");
			$("#last").css("display","block");
		}else if(${pageNo}==${pageCount}){
			$("#fir").css("display","block");
			$("#pre").css("display","block");
			$("#next").css("display","none");
			$("#last").css("display","none");
		}else{
			$("#fir").css("display","block");
			$("#pre").css("display","block");
			$("#next").css("display","block");
			$("#last").css("display","block");
		}
		
		//分页按钮点击事件
		$("#fir").click(function(){
			//pageNo改为1，并且提交表单
			$("input[name='pageNo']").val(1);
			$("form:first").submit();
		})
		$("#pre").click(function(){
			//pageNo减1，并且提交表单
			$("input[name='pageNo']").val(${pageNo}-1);
			$("form:first").submit();
		})
		$("#next").click(function(){
			//pageNo加1，并且提交表单
			$("input[name='pageNo']").val(${pageNo}+1);
			$("form:first").submit();
		})
		$("#last").click(function(){
			//pageNo最后一页，并且提交表单
			$("input[name='pageNo']").val(${pageCount});
			$("form:first").submit();
		})
	})
</script>