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


<link rel="stylesheet" type="text/css" href="web/admin/css/Iframe.css" />

</head>
<body>
	<span class="cp_title">修改商品</span>
	<div class="add_cp">
		<a href="goodsservlet?type=3">返回商品列表</a>
	</div>
	<div class="table_con">
		<%--		添加商品--%>
		<%--	id  商品名字    原价    打折价   商品图片  总库存  分类   描述 --%>
		<form action="goodsservlet?type=5" method="post"
			enctype="multipart/form-data">
			<%--		请求类型，2代表添加商品--%>
			<!-- 			<input type="hidden" name="type" value="2"> -->
			<%--		商家id，到时候要动态获取--%>
			<input type="hidden" name="businessid" value="1">
			<table style="width: 60%;height:80%;margin: 0 auto;">

				<tr>
					<td width="15%">商 品 名 字</td>
					<td align="center" style="margin: 0 auto;t"><input type="text"
						name="name" class="form-control" id="" placeholder="请输入产品名字"
						value="${goods.name }">
					</td>
				</tr>
				<tr>
					<td width="15%"><s>原 价</s>
					</td>
					<td><input type="text" name="oldprice" class="form-control"
						id="" placeholder="请输入价格" value="${goods.oldprice }"></td>
				</tr>
				<tr>
					<td width="15%">打 折 价</td>
					<td><input type="text" name="price" class="form-control" id=""
						placeholder="不打折忽略该行即可" value="${goods.price }">
					</td>
				</tr>
				<tr>
					<td width="15%">库 存 量</td>
					<td><input type="text" name="stock" class="form-control" id=""
						placeholder="请输入库存数量" value="${goods.stock }"></td>
				</tr>
				<tr style="height: 100px;">
					<td width="15%">分 类</td>
					<%--					这个地方需要通过三级分类id加载所有三级名称，返回值是 三级id数组，这个不是存到商品表里面，需要存到三级分类表中--%>
					<td><c:forEach items="${goods.classThreesList}" var="ct">
							<label class="checkbox-inline"> <input type="checkbox"
								id="inlineCheckbox1" name="threeclassid" value="${ct.id }">${ct.name
								} </label>
						</c:forEach>
					</td>


				</tr>

				<tr>
					<td width="15%">原预览图片</td>
					<td style="color: gray;">这里显示的效果图</td>

				</tr>
				<tr style="height: 120px;">
					<c:forEach items="${goods.goodsImgsList}" var="pics" varStatus="vs">
						<td><img style="width: 100px;height: 100px;background: #f0f;"
							alt="预览图片" src="${pics.imgaddress}">
						</td>
					</c:forEach>
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
					<td>商品 描述</td>
					<td><textarea placeholder="填下商品描述，最多支持200字哟" rows="3"
							cols="30" name="description">${goods.description }</textarea></td>
				</tr>
				<!-- 返回id -->
				<input type="hidden" name="id" value="${goods.id}">

				<tr>
					<td width="50%"><button type="reset" class="btn btn-warning"
							style="width: 60%;">重置上述数据</button></td>
					<td width="50%">
						<button style="width: 60%;" type="submit" class="btn btn-primary">提交商品信息</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>