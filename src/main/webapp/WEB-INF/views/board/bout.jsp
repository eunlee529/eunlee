<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th {
	background-color: #C8FFFF;
	text-align: center;
}

tr, caption {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="900" align="center">
		<caption>게시판 전체글</caption>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
			<th>groups</th>
			<th>step</th>
			<th>indent</th>
		</tr>
		<c:forEach items="${list}" var="bb">
			<tr>
				<td>${bb.boardnum}</td>
				<td style="text-align: left;"><c:forEach var="i" begin="0"
						end="${bb.indent}">
						&emsp;
					</c:forEach> <a href="detail?boardnum=${bb.boardnum}"> ${bb.boardtitle} </a></td>
				<td>${bb.boardwriter}</td>
				<td>${bb.boarddate}</td>
				<td>${bb.boardreadcnt}</td>
				<td>${bb.groups}</td>
				<td>${bb.step}</td>
				<td>${bb.indent}</td>

			</tr>
		</c:forEach>

		<!-- 페이징처리 555555-->
		<tr style="border-left: none; border-right: none; border-bottom: none">
			<td colspan="8" style="text-align: center;"><c:if
					test="${paging.startPage!=1 }">
					<a
						href="boardout?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage}"></a>
				</c:if> <c:forEach begin="${paging.startPage }" end="${paging.endPage}"
					var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b><span style="color: red;">${p}</span></b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="boardout?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
						</c:when>
					</c:choose>
				</c:forEach> <c:if test="${paging.endPage != paging.lastPage}">
					<a
						href="boardout?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">
					</a>
				</c:if></td>
		</tr>
		<!-- 페이징처리 5555555-->
	
	</table>
	
</body>
</html>