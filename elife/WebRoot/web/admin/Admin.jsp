<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'Admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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

<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
<link rel="stylesheet" href="css/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />

  </head>
 
  <body>
<span class="cp_title">管理员管理</span>
<!-- 搜索栏 -->
<form class="navbar-form navbar-left" role="search">
  <button type="button" class="btn btn-default navbar-btn">+添加管理员</button>
  <div class="form-group">
    <input type="text" class="form-control" placeholder="请输入搜索内容">
  </div>
  <button type="submit" class="btn btn-default">搜索</button>
</form>

<div class="table_con">
	<table>
    	<tr class="tb_title">
        	<td width="10%">id</td>
            <td width="20%">管理员名</td>
            <td width="12%">密码</td>
            <td width="12%">等级</td>
            <td width="21%">操作 </td>
        </tr>
       
        <tr>
        	<td width="10%">001</td>
            <td width="20%">叶梦雅</td>
            <td width="12%">123456</td>
            <td width="12%">商家</td>
           
            <td width="21%">
      
                <a class="sj_btn" href="" >编辑</a>
                <a class="del_btn" href="" >删除</a>

            </td>
        </tr>
        <tr>
        	<td width="10%">002</td>
            <td width="20%">张杰</td>
            <td width="12%">123456</td>
            <td width="12%">商家</td>
            
            <td width="21%">
            	
                <a class="sj_btn" href="" >编辑</a>
                <a class="del_btn" href="" >删除</a>

            </td>
        </tr>
    </table>
   
</div>
<div align="center">
 <nav>
		<ul class="pagination" >
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span> </a></li>
			<li><a href="#">1</a>
			</li>
			<li><a href="#">2</a>
			</li>
			<li><a href="#">3</a>
			</li>
			<li><a href="#">4</a>
			</li>
			<li><a href="#">5</a>
			</li>
			<li><a href="#">···</a>
			</li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
		</nav>
		</div>
</body>
</html>
