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
<form action="loginsave" method="post" >
<table border="1" width="350" align="center">
<caption>로그인</caption>
	<tr>
	<th>아이디</th>
	<td><input type="text" name="mid"></td>
	</tr>
	<tr>
	<th>비밀번호</th>
	<td><input type="password" name="mpw"></td>
	</tr>
	<tr>
	
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