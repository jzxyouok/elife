<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
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
	<span class="cp_title">说说管理</span>
	<div class="add_cp">
		<a href="AddNews.jsp">+添加说说</a>
		<div float="left">
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group" float="left">
					<input type="text" class="form-control" placeholder="请输入说说发表人">
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form>
		</div>
		<div class="dropdown" float="right">
			<button class="btn btn-default dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				Dropdown <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="#">Action</a></li>
				<li><a href="#">Another action</a></li>
				<li><a href="#">Something else here</a></li>
				<li><a href="#">Separated link</a></li>
			</ul>
		</div>
		<div></div>
	</div>



	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="4%" align="center">ID</td>
				<td width="30%" align="center">新闻内容</td>
				<td width="8%" align="center">点赞数量</td>
				<td width="8%" align="center">评论数量</td>
				<td width="8%" align="center">浏览人数</td>
				<td width="8%" align="center">发表人</td>
				<td width="8%" align="center">所属话题</td>
				<td width="8%" align="center">状态</td>
				<td width="18%" align="center">操作</td>
			</tr>
			<tr>
				<td width="4%" align="center">1</td>
				<td width="30%" align="center">习近平欢迎尼日总统访华并举行会谈总统访华并举行会谈利亚总统访华并举行会谈</td>
				<td width="8%" align="center">120</td>
				<td width="8%" align="center">2330</td>
				<td width="8%" align="center">12358</td>
				<td width="8%" align="center">张淳</td>
				<td width="8%" align="center">习近平</td>
				<td width="8%" align="center">未通过</td>
				<td width="18%" align="center"><a class="btn btn-primary"
					onclick="window.open('ModifyNews.jsp')" />编辑</a> <a
					class="btn btn-warning"
					onclick="window.location.href('Login.html')" />审核</a>&nbsp;<a
					class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
				</td>
			</tr>
			<tr>
				<td width="4%" align="center">1</td>
				<td width="30%" align="center">习近平欢迎尼日利亚总统访华并举行会谈</td>
				<td width="8%" align="center">120</td>
				<td width="8%" align="center">2330</td>
				<td width="8%" align="center">12358</td>
				<td width="8%" align="center">张淳</td>
				<td width="8%" align="center">习近平</td>
				<td width="8%" align="center">未审核</td>
				<td width="18%" align="center"><a class="btn btn-primary"
					onclick="window.open('ModifyNews.jsp')" />编辑</a> <a
					class="btn btn-warning"
					onclick="window.location.href('Login.html')" />审核</a>&nbsp;<a
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
			<li><span>1 <span class="sr-only">(current)</span> </span></li>
			<li class="active"><span>2 <span class="sr-only">(current)</span>
			</span></li>
			<li><span>3 <span class="sr-only">(current)</span> </span></li>
			<li><span>4 <span class="sr-only">(current)</span> </span></li>
			<li><span>5 <span class="sr-only">(current)</span> </span></li>
			<li class="disabled"><span> <span aria-hidden="true">&raquo;</span>
			</span></li>
		</ul>
		</nav>
	</div>
</body>
</html>