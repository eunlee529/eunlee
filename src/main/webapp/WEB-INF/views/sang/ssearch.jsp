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
<form action="sangsearch" method="post">
<table border="1" width="400" align="center">
<tr>
	<th>검색조건</th>
	<td>
	<input type="radio" name="key" value="snum">상품번호
	<input type="radio" name="key" value="sname">상품명
	</td>
</tr>
<tr>
	<th>검색어</th>
	<td>
	<input type="text" name="value">
	</td>
</tr>
<tr>
<td colspan="2">
	<input type="submit" value="검색">
	<input type="reset" value="검색취소" onclick="location.href='main'">
</td>
</tr>
</table>
</form>
</body>
</html>