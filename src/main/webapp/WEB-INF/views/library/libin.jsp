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
<form action="libsave" method="post" enctype="multipart/form-data">
<table border="1" width="400" align="center" >
<caption>도서입력창</caption>
<tr>
	<th>도서명</th>
	<td><input type="text" name="bname" >
	</td>	
</tr>
<tr>
	<th>저자명</th>
	<td><input type="text" name="bwriter"></td>	
</tr>

<tr>
	<th>출판일자</th>
	<td><input type="date" name="bdate"></td>	
</tr>
<tr>
	<th>도서소개</th>
	<td><textarea rows="5" cols="20" name="bintro">
		</textarea></td>
</tr>
<tr>
	<th>가격</th>
	<td><input type="text" name="bprice"></td>	
</tr>
<tr>
	<th>책표지</th>
	<td><input type="file" name="bimg"></td>	
</tr>
<tr style="text-align: center;">
	<td colspan="2">
	<input type="submit" value="전송"> 
	<input type="reset" value="취소"> 
	</td>
	</tr>
</table>
</form>
</body>
</html>