<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
background-color: 	#D2D2FF;
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
<form action="libsave" method="post">
<input type="hidden" name="bnum" value="${dto.bnum}">
<table border="1" width="400" align="center" >
<caption>자세히보기</caption>
<tr>
	<th>도서소개</th>
	<td><textarea rows="5" cols="20" name="bintro" >
	${dto.bintro}
		</textarea></td>
</tr>
<tr>
	<th>책표지</th>
	<td><img src="./image/${dto.bimg}" width="100" height="70"></td>	
</tr>
<tr style="text-align: center;">
	<td colspan="2">
	<input type="submit" value="댓글달기"> 
	<input type="button" value="취소" onclick="location.href='./'"> 
	</td>
	</tr>
</table>
</form>
</body>
</html>