<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
table tr td {
	text-align: center;
}
</style>
</head>
<body>
	<span class="cp_title">产品管理</span>
	<div class="add_cp">
		<a href="goodsservlet?type=1">+添加产品</a>
	</div>
	<div class="table_con">
		<%--ID 商品  商家名字  原价  现价  库存  销量   操作--%>
		<table>
			<tr class="tb_title">
				<td width="5%">ID</td>
				<td width="20%">商家</td>
				<td width="20%">产品名</td>
				<td width="10%"><div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							销量/库存 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">销量由低到高排序</a>
							</li>
							<li><a href="#">销量由高到低排序</a>
							</li>
							<li><a href="#">库存由低到高排序</a>
							</li>
							<li><a href="#">库存由高到低排序</a>
							</li>
						</ul>
					</div>
				</td>

				<td width="10%">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							现价/原价 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">现价由低到高排序</a>
							</li>
							<li><a href="#">现价由高到低排序</a>
							</li>
							<li><a href="#">原价由低到高排序</a>
							</li>
							<li><a href="#">原价由高到低排序</a>
							</li>
						</ul>
					</div></td>
				<td width="10%">状态</td>
				<td width="25%">操作</td>
			</tr>

			<c:forEach items="${goodsPager.objects }" var="goods">
				<tr>
					<td width="5%">${goods.id }</td>
					<td width="20%">${goods.username }</td>
					<td width="20%">${goods.name }</td>
					<td width="10%">${goods.sale }/${goods.stock }</td>
					<td width="10%">${goods.price }/${goods.oldprice }</td>
					<td width="10%">${goods.status }</td>
					<td width="25%"><a class="btn btn-primary"
						onclick="window.open('Login.html')" />编辑</a> <a
						class="btn btn-warning"
						onclick="window.location.href('Login.html')" />锁定</a> <a
						class="btn btn-danger" onclick="window.location.href('连接')" />删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		
		
		<!-- 分页处理 -->
		<!-- 		问题:不能保证当前页面每次都在中间。只能保证正常翻页 。最好可以每次保证当前页面在中间-->
		<!-- goodsPager就是一个Pagerlist对象 -->
		<nav class="text-center">
		<!-- 向前翻处理 -->
		<ul class="pagination">
			<!-- 		当当前页面小于等于1时，禁止向前翻页 -->
			<c:if test="${goodsPager.nowPager<=1}">
				<li class="disabled"><a aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span> </a>
				</li>
			</c:if>
			<c:if test="${goodsPager.nowPager>1}">
				<li><a
					href="goodsservlet?type=3&page=${goodsPager.nowPager-1 }"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a>
				</li>
			</c:if>

			<!-- 1~5页的处理 -->
			<c:forEach begin="1" end="5" varStatus="state">
				<c:if
					test="${goodsPager.nowPager==(state.index+goodsPager.nowPager/5*5-1)}">
					<li class="disabled"><a style="background: gray;color: white;"
						href="">${goodsPager.nowPager}</a>
					</li>
				</c:if>
				<!-- 获取格式化数据（不然会出现小数点），需要在最上面添加taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" -->
				<fmt:formatNumber var="c"
					value="${(state.index+goodsPager.nowPager/5*5-1)}" pattern="#" />
				<c:if test="${goodsPager.nowPager!=c}">
					<li><a href="goodsservlet?type=3&page=${c}">${c}</a></li>
				</c:if>
			</c:forEach>
			
			
			<!-- 		向后翻页 -->
			<c:if test="${goodsPager.nowPager+4>=goodsPager.totalPageNum}">
				<li class="disabled"><a aria-label="Previous"> <span
						aria-hidden="true">&raquo;</span> </a>
				</li>
			</c:if>
			<c:if test="${goodsPager.nowPager+4<goodsPager.totalPageNum}">
				<li><a
					href="goodsservlet?type=3&page=${goodsPager.nowPager+1 }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a>
				</li>
			</c:if>
		</ul>
		</nav>
</body>
</html>