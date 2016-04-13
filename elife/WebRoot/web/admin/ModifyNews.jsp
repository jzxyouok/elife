<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	function viewmypic(mypic, imgfile) {
		if (imgfile.value) {
			mypic.src = imgfile.value;
			mypic.style.display = "";
			mypic.border = 1;
		}
	}
</script>

</head>
<body>
	<h3 align="center">请填写新的活动内容：</h3>
	<form action="" align="center">
		<textarea rows="15" cols="30"></textarea>
		<br />
		<br /> <input name="imgfile" type="file" id="imgfile" size="40"
			onchange="viewmypic(showimg,this.form.imgfile);" /><br />
		<br /> <input type="submit" value="发表">&nbsp;&nbsp;&nbsp; <input
			type="reset" value="重置">
	</form>

</body>
</html>