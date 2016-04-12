<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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


</head>
<body>
	<div class="container">
		<h3>产品排行</h3>



		<%--	id  产品名字  商家名   销量   库存   原价  现价   状态--%>
		<table class="table table-hover" border="1"
			style="width: 600px;height: 100px;margin: 0 auto;margin-top: 20px;">
			<tr>
				<td>id</td>
				<td>产品名字</td>
				<td>商家名</td>
				<td>
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							销量 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">销量由高到低</a>
							</li>
							<li><a href="#">销量由低到高</a>
							</li>
						</ul>
					</div>
				</td>
				<td>库存</td>
				<td>原价</td>
				<td>现价</td>
				<td>状态</td>
			</tr>
			<tr>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>

			</tr>
			<tr>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>


			</tr>
			<tr>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>


			</tr>
			<tr>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>11</td>
				<td>12</td>

			</tr>
		</table>
	</div>
</body>
</html>