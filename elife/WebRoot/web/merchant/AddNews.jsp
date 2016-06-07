<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
<form action="" >
		<table align="center">
		<tr align="left"><td><h4>请填写说说内容：</h4></td></tr>
		<tr><td>
		<div class="form-group">
			<textarea class="form-control" rows="6" cols="80"></textarea>
		</div>
		</td>
		</tr>
		
		<tr align="left"><td><h4>请上传说说图片：</h4>
		</td></tr>
		<tr><td>
		<div >		
			<input type="file" name="file1" style="width:160px;" />
		</div></td></tr>
		<tr><td>
		<div align="center">
			<input type="submit" class="btn btn-default" value="发表"/> &nbsp;&nbsp;&nbsp; <input
				type="reset" value="重置" class="btn btn-default" />
		</div>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>