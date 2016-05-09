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

</head>
<body>

	<%--弹出对话框--%>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加三级分类名</h4>
				</div>
				<div class="modal-body">
					<input type="text" class="form-control" onchange="getThreeName()"
						id="threename" placeholder="请输入新的三级分类名，谨慎操作">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-info" onclick="addThreeName()">添加</button>
				</div>
			</div>
		</div>
	</div>


	<span class="cp_title">分类管理</span>
	<div class="add_cp">
		筛选信息：
		<%--	一级分类--%>
		<div class="dropdown" style="display: inline;">
			<button class="btn btn-default dropdown-toggle" type="button"
				id="firstName" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				一级分类 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li onclick="first(1)"><a>水果</a>
				</li>
				<li onclick="first(2)"><a>零食</a>
				</li>
				<li onclick="first(3)"><a>洗衣</a>
				</li>
				<li onclick="first(4)"><a>洗车</a>
				</li>
			</ul>
		</div>

		<%--		二级分类--%>
		<div class="dropdown" style="display: inline;">
			<button class="btn btn-default dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				二级分类 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="#">分类</a>
				</li>
				<li><a href="#">热卖</a>
				</li>
				<li><a href="#">地方特产</a>
				</li>

			</ul>

		</div>

		<%--		添加三级分类--%>
		<div class="dropdown" style="display: inline;">
			<%--			<button class="btn btn-default dropdown-toggle" type="button"--%>
			<%--				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"--%>
			<%--				aria-expanded="true">--%>
			<%--				二级分类 <span class="caret"></span>--%>
			<%--			</button>--%>

			<a data-toggle="modal" data-target="#myModal" class="btn btn-info" />
			添加三级分类 </a>
		</div>


	</div>





	<div class="table_con">
		<%--ID 三级名   所属二级分类   所属一级分类  操作--%>
		<table>
			<tr class="tb_title">
				<td width="10%">ID</td>
				<td width="30%">三级名</td>
				<td width="12%">所属二级分类</td>
				<td width="12%">所属一级分类</td>
				<td width="10%">操作</td>

			</tr>
			<c:forEach items="${classOneList}" var="one">
				<c:forEach items="${one.classsecondList }" var="second">
					<c:forEach items="${second.classthreeList }" var="three">
						<tr>
							<td width="10%">${three.id }</td>
							<td width="30%">${three.name }</td>
							<td width="12%">${second.name }</td>
							<td width="12%">${one.name }</td>
							<td width="26%"><a class="btn btn-primary"
								onclick="window.open('Login.html')" />编辑</a> <a data-toggle="modal"
								data-target="#myModal" class="btn btn-info"
								onclick="getSecondId(${second.id})" /> 添加 </a></td>
						</tr>

					</c:forEach>
				</c:forEach>
			</c:forEach>

		</table>

		<nav class="text-center">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> </a></li>
			<li class="disabled"><a href="#">1</a></li>
			<li><a href="#">2</a>
			</li>
			<li><a href="#">3</a>
			</li>
			<li><a href="#">4</a>
			</li>
			<li><a href="#">5</a>
			</li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
		</nav>


		<script type="text/javascript">
// 	一下三个函数为了完成添加三级分类
	var da;
	var secondId;
	function getThreeName() {
		var data= $("#threename").val();
		da=data;
		
	}
	function getSecondId(id){
	secondId=id;
	}
	function addThreeName(){
	self.location ="classservlet?type=2&secondId="+secondId+"&threeName="+da;
	}
	
	// 	下面开始处理筛选信息部分
	function first(flag){
	var f=flag;
	if(f==1){
	document.getElementById("firstName").innerHtml="水果";
	}else if(f==2){
	document.getElementById("firstName").innerHtml="零食";
	}else if(f==3){
	document.getElementById("firstName").innerHtml="洗衣";
	}else if(f==4){
	document.getElementById("firstName").innerHtml="洗车";
	}
	}
</script>
</body>
</html>