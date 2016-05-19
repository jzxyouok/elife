<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>商家管理</title>
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
	<span class="cp_title" style="width:100px;">商家管理</span>
	<!-- <div class="add_cp" >
		<a  href="AddBusiness.jsp" data-toggle="modal" 
      	data-target=".bs-example-modal-lg">+添加商家</a>
     </div> -->
	<div class="table_con add_cp">
		<a  href="../../getclassone" >+添加商家</a>
		<%--ID 商品  商家名字  原价  现价  库存  销量   操作--%>
		<table>
			<tr class="tb_title">
				<td width="10%">用户名</td>
				<td width="10%">商家名称</td>
				<td width="12%">手机号</td>
				<td width="13%">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">身份类型<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">零食</a></li>
							<li><a href="#">洗衣</a></li>
							<li><a href="#">洗车</a></li>
						</ul>
					</div>
				</td>
				<td width="15%">注册时间 </td>
				<td width="12%">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							地址 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">郑州航院</a></li>
							<li><a href="#">庙张</a></li>
							<li><a href="#">华水</a></li>
							<li><a href="#">警察学院</a></li>
						</ul>
					</div></td>
				<td width="9%">用户状态</td>
				<td width="19%" align="left">操作</td>
			</tr>
			<%
			int i = 6;
				while(i-- > 0){
			 %>
			<tr>
				<td width="10%"><a href="ShowBusiness.jsp" class="text-primary" id="link" >leke</a></td>
				<td width="10%">郑州航院</td>
				<td width="12%">18018126045</td>
				<td width="13%">零食</td>
				<td width="15%">航院南门50米</td>
				<td width="12%">2016-03-06</td>
				<td width="9%">可以登录</td>
				<td width="15%">
				 <a class="btn btn-warning" onclick="window.location.href('Login.html')" />锁定</a> 
				<a class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
				</td>
			</tr>
			<%
			}
			 %>
			
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