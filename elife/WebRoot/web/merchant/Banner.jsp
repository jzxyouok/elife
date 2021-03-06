<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.elife.utils.PageBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

</head>
<body>
<span class="cp_title">管理员管理</span>

<!-- 搜索栏 -->
<div class="add_cp">
		<a  data-toggle="modal" 
      	data-target=".bs-example-modal-lg">+添加管理员</a> 
     <div class="modal fade bs-example-modal-lg">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加管理员</h4>
				</div>
		<div class="modal-body">
		<!-- 这个地方放内容 -->
             <div class="table_con">
		          <table style="width: 60%;height:80%;margin: 5px auto;" >
					<tr>
						<td width="30%">管理员名字</td>
						<td align="center" style="margin: 8px auto;t"><input type="text" name="name" class="form-control" id=""
							placeholder="请输入管理员名字">
						</td>
					</tr>
					
				
					<tr>
						<td width="30%">密码</td>
						<td><input type="text" name="psword" class="form-control" id=""
							placeholder="请输入密码">
						</td>
					</tr>
					
					<tr>
						<td width="50%">选择上传头像</td>
						<td><input style="display: block;width: 100%;" type="file"
							name="img" id="exampleInputFile">
						</td>
						</td>
					</tr>
					
				</table>
		<div align="center" style="margin:5px">
		
			</div>
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
			按等级查询 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">按等级查询</a></li>
		</ul>
	</div>
</div>
</div>
<hr/>
	<span class="cp_title">轮播图管理</span>
	<div class="add_cp">
		<a href="web/admin/AddBanner.jsp">+添加轮播图</a>
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
			<c:forEach items="${pageBean.bannerList}" var="banner">
				<tr>
					<td width="6%" align="center">${banner.id }</td>
					<td width="20%" align="center">${banner.classfirst }</td>
					<td width="20%" align="center">${banner.classsecond }</td>
					<td width="20%" align="center">${banner.imgaddress }</td>
					<td width="20%" align="center">${banner.url }</td>
					<td width="14%" align="center"><a class="btn btn-primary"
						onclick="" href="web/admin/ModifyBanner.jsp?id=${banner.id}" />编辑</a>
						<a class="btn btn-danger" onclick="" href="/elife/bannerServlet?name=${'delete' }&id=${banner.id}" />删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<nav>
		<ul class="pagination">
			<!-- 如果当前页为首页，则Previous不可点击，否则，可以点击 -->
			<c:if test="${pageBean.pNum == 1}">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span> </a></li>
			</c:if>
			<c:if test="${pageBean.pNum != 1}">
				<li><a href="/elife/queryBanner?pNum=${pageBean.pNum-1 }"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<!-- 判断前面有没有5页 -->
			<c:if test="${pageBean.pNum-5>0}">
				<c:set var="begin" value="${pageBean.pNum-5}" scope="page" />
			</c:if>

			<!-- 判断后面有没有5页 -->
			<c:if test="${pageBean.pNum+5 < pageBean.totalPageNum}">
				<c:set var="end" value="${pageBean.pNum + 5}" scope="page" />
			</c:if>
			<!-- 设置首页为1,及最后一页 -->
			<c:set var="begin" value="1" scope="page" />
			<c:set var="end" value="${pageBean.totalPageNum}" scope="page" />
			<!-- 当前页不显示链接 -->
			<c:forEach begin="${begin}" end="${end}" var="i">
				<c:if test="${pageBean.pNum==i}">
					<li><a href="#">${i}</a>
					</li>
				</c:if>
				<c:if test="${pageBean.pNum!=i}">
					<li><a href="/elife/queryBanner?pNum=${i }">${i }</a>
					</li>
				</c:if>
			</c:forEach>

			<!-- 如果当前页是最后一页，则 Next 不可点击，否则可以点击 -->
			<c:if test="${pageBean.pNum == pageBean.totalPageNum}">
				<li><a href="/elife/queryBanner?pNum=${pageBean.pNum + 1 }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
			</c:if>
			<c:if test="${pageBean.pNum != pageBean.totalPageNum}">
				<li><a href="/elife/queryBanner?pNum=${pageBean.pNum + 1 }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
			</c:if>
		</ul>
		</nav>
	</div>
</body>
</html>