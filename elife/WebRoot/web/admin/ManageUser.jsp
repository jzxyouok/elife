<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
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
	#link{
		text-decoration: none;
	}
	#link:hover{
		color:#B70D24;
	}
</style>

</head>
<body>
	<span class="cp_title">用户管理</span>
	<div class="table_con">
		<%--ID 商品  商家名字  原价  现价  库存  销量   操作--%>
		<table>
			<tr class="tb_title">
				<td width="10%">用户名</td>
				<td width="10%">昵称</td>
				<td width="12%">手机号</td>
				<td width="13%">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">学校 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">郑州航院</a></li>
							<li><a href="#">华水</a></li>
							<li><a href="#">河南职业学院</a></li>
						</ul>
					</div>
				</td>
				<td width="15%">地址</td>
				<td width="12%">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							注册时间 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">一月</a></li>
							<li><a href="#">二月</a></li>
							<li><a href="#">三月</a></li>
							<li><a href="#">四月</a></li>
						</ul>
					</div></td>
				<td width="9%">用户状态</td>
				<td width="19%" align="left">操作</td>
			</tr>
			<tr>
				<td width="10%"><a href="ShowUser.jsp" class="text-primary" id="link" >zua</a></td>
				<td width="10%">大baby</td>
				<td width="12%">18018126045</td>
				<td width="13%">郑州航院</td>
				<td width="15%">5#121</td>
				<td width="12%">2016-03-06</td>
				<td width="9%">可以登录</td>
				<td width="15%">
				 <a class="btn btn-warning" onclick="window.location.href('Login.html')" />锁定</a> 
				<a class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
				</td>
			</tr>
			
		</table>

		<nav class="text-center">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> </a>
			</li>
			<li class="disabled"><a href="#" >1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a>
			</li>
		</ul>
		</nav>
</body>
</html>