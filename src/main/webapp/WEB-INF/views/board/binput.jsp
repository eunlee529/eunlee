<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
background-color: 	#C8FFFF;
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
<form action="boardsave" method="post">
<table border="1" width="300" align="center">
<caption>게시판 글올리기</caption>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="boardwriter"></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><input type="text" name="boardtitle"></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td><textarea rows="5" cols="20" name="boardcontent"></textarea></td>
	</tr>
	<tr style="text-align: center;">
	<td colspan="2">
	<input type="submit" value="전송"> 
	<input type="button" value="취소..메인" onclick="location.href='./'"> 
	</td>
	</tr>
</table>
</form>
</body>
</html>