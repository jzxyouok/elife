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
	<span class="cp_title">修改管理员</span>
	
	<div class="table_con">
	<form action="/elife/adminServlet?name=${'updata'}&id=<%= adminid %>" method="post"
			enctype="MULTIPART/FORM-DATA">
		<table style="width: 60%;height:80%;margin: 2px auto;" >
			<tr>
				<td width="20%">管理员名字</td>
				<td align="center" style="margin: 5px auto;t"><input type="text" name="name" class="form-control" id=""
					placeholder="叶梦雅">
				</td>
			</tr>
			
			<tr>
				<td width="20%">密码</td>
				<td><input type="text" name="price" class="form-control" id=""
					placeholder="123456">
				</td>
			</tr>
			
			
			<tr>
				<td width="40%">选择上传头像</td>
				<td><input style="display: block;width: 100%;" type="file"
					name="img" id="exampleInputFile">
				</td>
				
			</tr>
	</table>
		<div align="center" style="margin:5px">
		<tr>
				<td width="50%"><button type="reset" class="btn btn-warning">重置</button>
				</td>
				<td width="50%">
					<button type="submit" class="btn btn-primary">提交</button>
				</td>
			</tr>
			</div>
			</form>
	</div>
</body>
</html>