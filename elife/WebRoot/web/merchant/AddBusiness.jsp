<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<link rel="stylesheet" type="text/css" href="web/admin/css/Iframe.css" />

<style type="text/css">
.checkbox{
	margin-left: 5px;
}
</style>

</head>
<body>
	<span class="cp_title">添加商家</span>
	<div class="add_cp">
		<a href="ManageBusiness.jsp">返回商家列表</a>
	</div>
	<div class="table_con">
		<form action="businessservlet?action=add" method="post" enctype="multipart/form-data">

			<table style="width: 60%;height:80%;margin: 0 auto;">
				<tr>
					<td width="15%">手机号：</td>
					<td align="center" style="margin: 0 auto;">
					<input type="text"	name="phone" class="form-control" id="" placeholder="请输入手机号">
					</td>
				</tr>
				<tr>
					<td width="15%">商家名称：</td>
					<td><input type="text" name="storename" class="form-control"
						id="" placeholder="请输入名称">
					</td>
				</tr>
				<tr>
					<td width="15%">身份类型：</td>
					<td>
					<c:forEach items="${requestScope.classonelist }" var="item">
					<input type="checkbox" name="type" value="${item.id }" />&nbsp;${item.name}&nbsp;
					</c:forEach>
					
					</td>
				</tr>
				<tr>
					<td width="15%">地址：</td>
					<td><input type="text" name="address" class="form-control" id=""
						placeholder="请输入地址">
					</td>
				</tr>
				<tr>
					<td width="15%">广告图：</td>
					<td><input type="file" name=imageurl id="">
					</td>
				</tr>
				<tr>
					<td width="15%">广告图预览：</td>
					<td><img alt="" src="" />
					</td>
				</tr>
				<tr style="height:150px;">
					<td width="15%">商家描述：</td>
					<td>
					<textarea name="decription" style="height:100px;width:750px;" name="decription">再次输入一些商家的描述</textarea>
					</td>
				</tr>
				<tr>
					<td width="50%"><button type="reset" class="btn btn-warning"
							style="width: 60%;">重置上述数据</button>
					</td>
					<td width="50%">
						<button style="width: 60%;" type="submit" class="btn btn-primary">提交商家信息</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>