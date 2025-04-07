<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
background-color: 	#A5E3E6;
text-align: center;
}
tr,caption{
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ssave" method="post" enctype="multipart/form-data">
<table border="1" width="400" align="center">
<caption>상품입력</caption>
	<tr>
	<th>상품명</th>
	<td><input type="text" name="sname"></td>
	</tr>
	<tr>
	<th>상품이미지</th>
	<td><input type="file" name="simg"></td>
	</tr>
	
	<tr align="center">
		<td colspan="2">
		<input type="submit" value="전송">
		<input type="reset" value="취소">
		</td>
	
	</tr>
	
</table>
</form>
</body>
</html>