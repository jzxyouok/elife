<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- <script type="text/javascript">
	/* function showPic(obj){
		var str=obj.value;
		document.getElenmentById("picture").innerHTML="<img src='"+str="'/>";
	} */
	$(function() {
		$("#myfile").change(function() {
			$("#previewImg").attr("src", "file:///" + $("#myfile").val());
		});
	});
</script> -->
</head>
<body>
	<span class="cp_title">轮播图管理</span>
	<div align="center">
		<label><h3>添加轮播图</h3> </label>
		<form action="/elife/bannerServlet?name=${'add'}" method="post" enctype="multipart/form-data">
			<table style="width: 40%;height:80%;margin: 0 auto;">
				<tr>
					<td>选择一级分类：</td>
					<td><div class="form-group">
							<select class="form-control" name="classfirst">
								<option>一级分类</option>
								<option>零食</option>
								<option>洗衣</option>
								<option>洗车</option>
								<option>水果</option>
							</select>
						</div></td>
				</tr>
				<tr>
					<td>选择二级分类：</td>
					<td><div class="form-group">
							<select class="form-control" name="classsecond">
								<option>二级分类</option>
								<option>肉类</option>
								<option>坚果脯</option>
							</select>
						</div></td>
				</tr>
				<tr>
					<td>链接URL：</td>
					<td><input type="text" name="url" class="form-control" id=""
						placeholder="请输入url地址"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td></td>
				</tr>
				<tr>
					<td>上传轮播图图片：</td>
					<td><input type="file" name="imagefile" style="width:160px;"
						/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td></td>
				</tr>
			</table>
			<input class="btn btn-default" type="submit" name="submit" value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input class="btn btn-default" type="reset" value="重置" />
		</form>
	</div>
</body>
</html>