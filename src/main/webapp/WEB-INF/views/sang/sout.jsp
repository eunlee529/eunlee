<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<table border="2" width="400" align="center">
<tr>
	<th>상품번호</th><th>상품명</th><th>상품이미지</th><th>비고</th>
</tr>
<c:forEach items="${list}" var="my">

	<tr>
	
		<td>${my.snum}</td>
		<td>${my.sname}</td>
		<td> <img  src="./image/${my.simg}" width="100" height="70">
		</td>
		<td>
		<a href="delete11?snum=${my.snum}">삭제&emsp;</a>
		<a href="modify12?snum=${my.snum}">수정</a>
		</td>
	</tr>
	
</c:forEach>
</table>
</body>
</html>