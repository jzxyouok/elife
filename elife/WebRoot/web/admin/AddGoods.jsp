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
	<span class="cp_title">添加商品</span>
	<div class="add_cp">
		<a href="ShowGoodsList.jsp">"<<"返回商品列表</a>
	</div>
	<div class="table_con">
		<%--		添加商品--%>
		<%--	id  商品名字    原价    打折价   商品图片  总库存  分类   描述 --%>
		<form action="" method="post">
			<table style="width: 60%;height:80%;margin: 0 auto;">

				<tr>
					<td width="15%">商 品 名 字</td>
					<td align="center" style="margin: 0 auto;t"><input type="text"
						name="name" class="form-control" id="" placeholder="请输入产品名字">
					</td>
				</tr>
				<tr>
					<td width="15%"><s>原 价</s></td>
					<td><input type="text" name="oldprice" class="form-control"
						id="" placeholder="请输入价格">
					</td>
				</tr>
				<tr>
					<td width="15%">打 折 价</td>
					<td><input type="text" name="price" class="form-control" id=""
						placeholder="请输入打折价格，不打折输入0，或者忽略">
					</td>
				</tr>
				<tr>
					<td width="15%">库 存 量</td>
					<td><input type="text" name="stock" class="form-control" id=""
						placeholder="请输入库存数量">
					</td>
				</tr>
				<tr>
					<td width="15%">分 类</td>
					<td><div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								选择分类 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="#">甜食</a></li>
								<li><a href="#">辣食</a></li>
								<li><a href="#">小甜饼</a></li>
								<li><a href="#">麻辣烫</a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td width="15%">上传图片</td>
					<td style="color: gray;">最多支持四张商品图片</td>

				</tr>
				<tr>
					<td><input style="display: block;" type="file" name="img">
					</td>
					<td><input style="display: block;" type="file" name="img">
					</td>
					<td><input style="display: block;" type="file" name="img">
					</td>
					<td><input style="display: block;" type="file" name="img">
					</td>
				</tr>
				<tr style="height: 100px;">
					<td >商品 描述</td>
					<td ><textarea placeholder="填下商品描述，最多支持200字哟"  rows="3"
							cols="30" name="description"></textarea>
					</td>
				</tr>

				<tr>
					<td width="50%"><button type="reset" class="btn btn-warning"
							style="width: 60%;">重置上述数据</button>
					</td>
					<td width="50%">
						<button style="width: 60%;" type="submit" class="btn btn-primary">提交商品信息</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>