<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delsave" method="post" >
		<table border="1" width="400" align="center">
			<caption>상품삭제</caption>
			<tr>
				<th>상품번호</th>
				<td><input type="text" name="snum" value="${dto.snum}"
					readonly></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="sname" value="${dto.sname}"></td>
			</tr>
			<tr>
				<th>상품이미지</th>
				<td>
				<img src="./image/${dto.simg}" width="100" height="70">
				</td>
			</tr>
			<tr>
			<td><input type="hidden" name="himg" value="${dto.simg}"></td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
				<input type="submit" value="삭제확인"> 
				<input type="reset" value="취소" onclick="location.href='main'"></td>

			</tr>

		</table>
	</form>
</body>
</html>