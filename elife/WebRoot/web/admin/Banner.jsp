<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<span class="cp_title">轮播图管理</span>
	<div class="add_cp">
		<a href="AddBanner.jsp">+添加轮播图</a>
	</div>
	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="6%" align="center">ID</td>
				<td width="20%" align="center">一级分类</td>
				<td width="20%" align="center">二级分类</td>
				<td width="20%" align="center">图片地址</td>
				<td width="20%" align="center">链接地址</td>
				<td width="14%" align="center">操作</td>
			</tr>
			<tr>
				<td width="6%" align="center">1</td>
				<td width="20%" align="center">零食</td>
				<td width="20%" align="center">坚果</td>
				<td width="20%" align="center">abjhdis45467df</td>
				<td width="20%" align="center">www.baidu.com</td>
				<td width="14%" align="center"><a class="btn btn-primary"
					onclick="window.open('AddBanner.jsp')" />编辑</a> <a
					class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
				</td>
			</tr>
			<tr>
				<td width="6%" align="center">1</td>
				<td width="20%" align="center">零食</td>
				<td width="20%" align="center">坚果</td>
				<td width="20%" align="center">abjhdis45467df</td>
				<td width="20%" align="center">www.baidu.com</td>
				<td width="14%" align="center"><a class="btn btn-primary"
					onclick="window.open('AddBanner.jsp')" />编辑</a> <a
					class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
				</td>
			</tr>
			<tr>
				<td width="6%" align="center">1</td>
				<td width="20%" align="center">零食</td>
				<td width="20%" align="center">坚果</td>
				<td width="20%" align="center">abjhdis45467df</td>
				<td width="20%" align="center">www.baidu.com</td>
				<td width="14%" align="center"><a class="btn btn-primary"
					onclick="window.open('AddBanner.jsp')" />编辑</a> <a
					class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
				</td>
			</tr>
						
		</table>

	</div>
	<div align="center">
		<nav>
		<ul class="pagination">
			<li class="disabled"><span> <span aria-hidden="true">&laquo;</span>
			</span></li>
			<li><span>1 <span class="sr-only">(current)</span>
			</span></li>
			<li class="active"><span>2 <span class="sr-only">(current)</span>
			</span></li>
			<li><span>3 <span class="sr-only">(current)</span>
			</span></li>
			<li><span>4 <span class="sr-only">(current)</span>
			</span></li>
			<li><span>5 <span class="sr-only">(current)</span>
			</span></li>
			<li class="disabled"><span> <span aria-hidden="true">&raquo;</span>
			</span></li>
		</ul>
		</nav>
	</div>
</body>
</html>