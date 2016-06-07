<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示商家信息</title>
<%--<!-- 新 Bootstrap 核心 CSS 文件 -->--%>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<%--<!-- 可选的Bootstrap主题文件（一般不用引入） -->--%>
<%--<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">--%>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<style type="text/css">
	table tr td{
		text-align: center;
	}
	table tr td.tdbg{
		background-color: #E3E3E3;
	}
</style>

</head>
<body>
	<span class="cp_title">商家详细信息</span>
	<div class="add_cp">
		<a href="ManageBusiness.jsp">返回商家列表</a>
	</div>
	<div class="table_con">
		
		<form action="" method="post">
			<table style="width: 60%;height:80%;margin: 0 auto;">

				<tr>
					<td width="25%"  class="tdbg">手机号：</td>
					<td width="25%" >13298282779</td>
					<td width="25%"  class="tdbg">商家名称：</td>
					<td width="25%" >乐可便利</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">地址</td>
					<td width="70%">郑州航院东校区</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">身份类型</td>
					<td width="75%">零食、洗车</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">邮箱</td>
					<td width="75%">571146698@qq.com</td>
				</tr>
				
				<tr>
					<td width="25%"  class="tdbg">注册时间</td>
					<td width="25%">2015-02-23</td>
					<td width="25%"  class="tdbg">最后登录时间</td>
					<td width="25%">2016-03-07</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>