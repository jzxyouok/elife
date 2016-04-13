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
		<a href="#">+添加轮播图</a>
	</div>
	<div align="center">
		<label><h3>添加轮播图</h3>
			</label>
		<form action="">
			<table style="width: 40%;height:80%;margin: 0 auto;">
				<tr><td>选择一级分类：</td>
					<td><div class="form-group">
							<select class="form-control">
								<option>一级分类</option>
								<option>零食</option>
								<option>洗衣</option>
								<option>洗车</option>
								<option>水果</option>
							</select>
						</div></td>
				</tr>
				<tr><td>选择二级分类：</td>
					<td><div class="form-group">
							<select class="form-control">
								<option>二级分类</option>
								<option>肉类</option>
								<option>坚果脯</option>
							</select>
						</div></td>
				</tr>
				<tr><td>链接URL：</td>
					<td>
					<input type="text" name="name" class="form-control" id=""
						placeholder="请输入url地址"></td>
				</tr>
				<tr><td>&nbsp;</td><td></td></tr>
				<tr><td>上传轮播图图片：</td>
					<td><input type="file" name="file1" style="width:160px;" /></td>
				</tr>
				<tr><td>&nbsp;</td><td></td></tr>
				
					
				
			</table>
			
<input class="btn btn-default" type="submit" value="发布">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-default" type="reset" value="重置">
		</form>
	</div>
</body>
</html>