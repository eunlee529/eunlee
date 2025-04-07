<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#logcheck").click(function(){
		var id=$("#id").val();
		$.ajax({
			type:"post",
			url:"logcheck",
			data:{"mid":id},
			async:true,
			success:function(data){
				if(data=="ok")
				{
				alert("yes~ 사용가능 id");
				}
			else
				{
				alert("no! 사용중 id");
				}
			
		}
		
	});
});
});
</script>
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
<form action="memsave" method="post" >
<table border="1" width="350" align="center">
<caption>로그인</caption>
	<tr>
	<th>아이디</th>
	<td><input type="text" name="mid" id="id"><br>
	<input type="button" value="id중복" id="logcheck">	</td>
	</tr>
	<tr>
	<th>비밀번호</th>
	<td><input type="password" name="mpw"></td>
	</tr>
	<tr>
	<th>이름</th>
	<td><input type="text" name="mname"></td>
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