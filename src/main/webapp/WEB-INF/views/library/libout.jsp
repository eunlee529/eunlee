<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<table border="4" width="700" align="center">
<caption>도서자료출력</caption>
<tr>
	<th>도서번호</th><th>도서명</th><th>저자명</th>
	<th>출판일</th><th>도서소개</th><th>도서가격</th>
	<th>도서표지</th><th>조회수</th><th>비고</th>
</tr>
<c:forEach items="${list}" var="bb">
<tr>
	<td>${bb.bnum}</td>
	 <td style="text-align: left;">&emsp;
	 <a href="libdetail?bnum=${bb.bnum}">${bb.bname}
	 </a>
	 </td>
	<td>${bb.bwriter}</td>
	<td>${bb.bdate}</td>
	<td>${bb.bintro}</td>
	<td>${bb.bprice}</td>
	<td><img  src="./image/${bb.bimg}" width="100" height="70"> </td>
	<td>${bb.libreadcnt}</td>
	<td>
<a href="modify?bnum=${bb.bnum}">수정&emsp;</a>
<a href="delete?bnum=${b.bnum}">삭제</a>
</td>
</tr>
</c:forEach>


</table>
</body>
</html>