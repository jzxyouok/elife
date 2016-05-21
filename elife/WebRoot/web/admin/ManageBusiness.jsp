<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>商家管理</title>
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
	#link{
		text-decoration: none;
	}
	#link:hover{
		color:#B70D24;
	}
	td{
		text-align: center;
	}
</style>

</head>
<body>
	<span class="cp_title" style="width:100px;">商家管理</span>
	<!-- <div class="add_cp" >
		<a  href="AddBusiness.jsp" data-toggle="modal" 
      	data-target=".bs-example-modal-lg">+添加商家</a>
     </div> -->
	<div class="table_con add_cp">
		<a  href="getclassone" >+添加商家</a>
		<%--ID 商品  商家名字  原价  现价  库存  销量   操作--%>
		<table>
			<tr class="tb_title">
				<td width="10%">用户名</td>
				<td width="10%">商家名称</td>
				<td width="12%">手机号</td>
				<td width="13%">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">身份类型<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<c:forEach items="${requestScope.allClassone }" var="type">
								<li><a href="businessservlet?action=show&typeid=${type.id }">${type.name }</a></li>
							</c:forEach>
							
						</ul>
					</div>
				</td>
				<td width="15%">注册时间 </td>
				<td width="12%">
					地址
					<!-- <div class="dropdown">目前不提供按照地址选择商家
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							地址 <span class="caret"></span>
						</button>
						
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">郑州航院</a></li>
							<li><a href="#">庙张</a></li>
							<li><a href="#">华水</a></li>
							<li><a href="#">警察学院</a></li>
						</ul>
					</div> -->
					</td>
				<td width="9%">用户状态</td>
				<td width="19%" align="left">操作</td>
			</tr>
			
			 <c:forEach items="${requestScope.businesslist}" var="business">
			<tr>
				<td width="10%"><a href="ShowBusiness.jsp" class="text-primary" id="link" >${business.nickname }</a></td>
				<td width="10%">${business.storename }</td>
				<td width="12%">${business.phone }</td>
				<td width="13%">${business.identity}</td>
				<td width="15%">${business.lasttime}</td>
				<td width="12%">${business.address }</td>
				<td width="9%">
				<c:choose>
				<c:when test="${business.status == 1}">
				可以登录
				</c:when>
				<c:otherwise>
				不能登录
				</c:otherwise>
				</c:choose>
				</td>
				<td width="15%">
				
				 <a class="btn btn-warning" href="businessservlet?action=lock&id=${business.id}&status=${business.status}" />锁定</a> 
				<!-- <a class="btn btn-danger" onclick="window.location.alert('连接')"  />删除</a> -->
				<span class="btn btn-danger" data-toggle="modal"
						onclick="prepareDel(${business.id })"
						data-target=".bs-example-modal-sm"><c:set var="myid"
								value="${business.id }" />删除</span>
				</td>
			</tr>
			</c:forEach>
			
			
		</table>

		<nav class="text-center">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> </a>
			</li>
			<li class="disabled"><a href="#" >1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a>
			</li>
		</ul>
		</nav>
		
		
		
		<!-- 		以下处理删除时的弹出框 -->
		<div class="modal fade bs-example-modal-sm">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">请确认</h4>
					</div>
					<div class="modal-body">
						<p>目前不支持删除商家操作</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<!-- onclick="javascript:window.location.href='goodsservlet?type=6&id=${myid}';" -->
						<a class="btn btn-danger" onclick="processDel()">删除</a>

					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div> 
		<!-- /.modal -->
		<!-- 	弹出框结束 -->
</body>

<script type="text/javascript">
	function myRank(mtype, mrank) {
		var type = mtype;
		var rank = mrank;
		self.location = 'goodsservlet?type=' + type+'&rank='+rank;
	}
// 	以下两个函数处理删除问题
	var myid;
	function prepareDel(id){
	 myid=id;
	}
	
	function processDel() {
		self.location ="传递给操作商家";
	}
</script>
</html>