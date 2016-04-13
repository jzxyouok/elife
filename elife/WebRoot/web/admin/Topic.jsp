<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>话题</title>

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

</head>

<body>
	<span class="cp_title">话题管理</span>

	<!-- 对话框 -->
	<!-- 这个按钮可以独立出来 -->
	<div class="add_cp">
		<a  data-toggle="modal" 
      	data-target=".bs-example-modal-lg">+添加话题</a> 
     <div class="modal fade bs-example-modal-lg">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加话题</h4>
				</div>
				<div class="modal-body">
					<!-- 这个地方放内容 -->
                      <div class="table_con">
						<table style="width: 85%;height:50%;margin: 5px auto;">
							<tr>
								<td width="25%">话题名称</td>
								<td align="center" style="margin: 8px auto;t"><input
									type="text" name="name" class="form-control" id=""
									placeholder="请输入话题名称">
								</td>
							</tr>

							<tr>
								<td width="25%">参与量</td>
								<td><input type="text" name="price" class="form-control"
									id="" placeholder="请输入参与人数">
								</td>
							</tr>
                            <tr>
								<td width="28%">选择上传图片</td>
								<td><input style="display: block;width: 100%;"
									type="file" name="img" id="exampleInputFile">
								</td>
                           </tr>
                   </table>
						
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-info">添加</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div float="left">
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group" float="left">
				<input type="text" class="form-control" placeholder="请输入搜索内容">
			</div>
			<button type="submit" class="btn btn-default">搜索</button>
		</form>
	</div>
	<div class="btn-group" style="margin:8px auto;">
		<button type="button" class="btn btn-info dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			按参与量查询 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">按参与量查询</a></li>
			<li><a href="#">按创建时间查询</a></li>
			<li><a href="#">查询未审核话题</a></li>
		</ul>
	</div>
</div>
	<div class="table_con">
		<table>
			<tr class="tb_title">
				<td width="10%">id</td>
				<td width="20%">话题</td>
				<td width="12%">参与量</td>
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
				<td width="21%"><a class="btn btn-primary"
					onclick="window.open('TopicAlter.jsp')" />编辑</a> <a
					class="btn btn-warning"
					onclick="window.location.href('Login.html')" />审核</a> <a
					class="btn btn-danger" onclick="window.location.href('连接')" />禁用</a>
			</tr>
			<tr>
				<td width="10%">002</td>
				<td width="20%">#张杰郑州演唱会#</td>
				<td width="12%">100000</td>
				<td width="12%">已通过</td>
				<td width="15%">2016-04-12 16:05</td>
				<td width="10%">叶梦雅</td>
				<td width="21%"><a class="btn btn-primary"
					onclick="window.open('TopicAlter.jsp')" />编辑</a> <a
					class="btn btn-warning"
					onclick="window.location.href('Login.html')" />审核</a> <a
					class="btn btn-danger" onclick="window.location.href('连接')" />禁用</a>
				</td>
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
