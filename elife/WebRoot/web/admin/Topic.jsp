<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'Topic.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<link rel="stylesheet" href="css/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />
</head>

<body>
	<span class="cp_title">话题管理</span>
	<!-- 搜索栏 -->
	<div class="add_cp">
		<a href="AddTopic.jsp">+添加话题</a>
	
	<div float="left">
<form class="navbar-form navbar-left" role="search">
  <div class="form-group" float="left">
  <input type="text" class="form-control" placeholder="请输入搜索内容">
  </div>
  <button type="submit" class="btn btn-default">搜索</button>
</form>
</div>
</div>
	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="10%">id</td>
				<td width="20%">话题</td>
				<td width="12%">
                       <div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							参与量<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">按照参与量从多到少排序</a>
							</li>
						</ul>
					</div>
               </td>
				<td width="12%">审核</td>
				<td width="15%">创建时间</td>
				<td width="10%">创建人</td>
				<td width="21%">操作</td>
			</tr>

			<tr>
				<td width="10%">001</td>
				<td width="20%">#王高远真帅！！！#</td>
				<td width="12%">10000</td>
				<td width="12%"><font color=blue>未通过</font>
				</td>
				<td width="15%">2016-04-12 16:05</td>
				<td width="10%">叶梦雅</td>
				<td width="21%">
				<a class="bj_btn" href="TopicAlter.jsp">编辑</a> 
				<a class="sj_btn" href="">审核</a> 
				<a class="del_btn" href="">禁用</a></td>
			</tr>
			<tr>
				<td width="10%">002</td>
				<td width="20%">#张杰郑州演唱会#</td>
				<td width="12%">100000</td>
				<td width="12%">已通过</td>
				<td width="15%">2016-04-12 16:05</td>
				<td width="10%">叶梦雅</td>
				<td width="21%">
				
				<a class="bj_btn" href="TopicAlter.jsp">编辑</a> 
				<a class="sj_btn" href="">审核</a> 
				<a class="del_btn" href="">禁用</a></td>
			</tr>
		</table>
		</div>
		<div align="center">
		<nav>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> </a></li>
			<li><a href="#">1</a>
			</li>
			<li><a href="#">2</a>
			</li>
			<li><a href="#">3</a>
			</li>
			<li><a href="#">4</a>
			</li>
			<li><a href="#">5</a>
			</li>
			<li><a href="#">···</a>
			</li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
		</nav>
		
	</div>
</body>
</html>
