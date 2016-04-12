<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<link rel="stylesheet" type="text/css" href="css/Iframe.css" />
	<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
    <span class="cp_title">活动管理</span>
<div>
	<ul class="nav nav-tabs">
	  <li role="presentation" class="active"><a href="#">查询活动</a></li>
	  <li role="presentation"><a href="#">添加活动</a></li>
	  <li role="presentation"><a href="#">Messages</a></li>
	</ul>
</div>
<div class="table_con">
	<table>
    	<tr class="tb_title">
			<td width="6%" align="center">状态</td>
        	<td width="48%" align="center">活动内容</td>
            <td width="8%" align="center">点赞数量</td>
            <td width="10%" align="center">评论的数量</td>
            <td width="8%" align="center">浏览人数</td>
            <td width="8%" align="center">发表人</td>
            <td width="12%" align="center">所属话题</td>
		</tr>
    </table>
	<nav>
  <ul class="pagination">
    <li class="disabled">
      <span>
        <span aria-hidden="true">&laquo;</span>
      </span>
    </li>
    <li >
      <span>1 <span class="sr-only">(current)</span></span>
    </li>
    <li class="active">
      <span>2 <span class="sr-only">(current)</span></span>
    </li>
	<li>
      <span>3 <span class="sr-only">(current)</span></span>
    </li>
  </ul>
</nav>
</div>
  </body>
</html>