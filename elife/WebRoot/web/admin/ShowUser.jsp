<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示用户信息</title>
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
	<span class="cp_title">添加商品</span>
	<div class="add_cp">
		<a href="ManageUser.jsp">返回用户列表</a>
	</div>
	<div class="table_con">
		
		<form action="" method="post">
			<table style="width: 60%;height:80%;margin: 0 auto;">

				<tr>
					<td width="20%"  class="tdbg">用户名：</td>
					<td width="18%" >zua</td>
					<td width="19%"  class="tdbg">昵称：</td>
					<td width="18%" >大baby</td>
					<td width="25%" colspan="2"><img src="" width="74" height="74"/></td>
				</tr>
				<tr>
					<td width="12.5%"  class="tdbg">性别</td>
					<td width="12.5%">男</td>
					<td width="12.5%"  class="tdbg">年龄</td>
					<td width="12.5%">21</td>
					<td width="13%"  class="tdbg">出生日期</td>
					<td width="12%">2016-03-06</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">手机号</td>
					<td width="25%">18018126045</td>
					<td width="25%"  class="tdbg">邮箱</td>
					<td width="25%">123654987@qq.com</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">地址</td>
					<td width="75%">5#121</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">学校</td>
					<td width="25%"> 郑州航院</td>
				</tr>
				<tr>
					<td width="25%"  class="tdbg">用户状态</td>
					<td width="25%">可以登录</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>