<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<h2>
MBC 아카데미 게시판
</h2>
</header>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main">(ᴗ͈ˬᴗ͈)ഒ</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="boardinput">게시판글올리기</a></li>
          <li><a href="boardout">게시판글출력</a></li>
          <li class="divider"></li>
          <li><a href="mapgo">다음지도</a></li>
           
        </ul>
      </li>    
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">도서정보 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="libinput">도서정보입력</a></li>
          <li><a href="libout">도서정보출력</a></li>
          <li class="divider"></li>
        </ul>
      </li>   
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">상품정보 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="sanginput">상품정보입력</a></li>
          <li><a href="sangout">상품정보출력</a></li>
           <li class="divider"></li>
          <li><a href="sangsearchview">상품정보검색</a></li>
         
        </ul>
      </li>  
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판2 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="binput">게시판작성</a></li>
          <li><a href="bout">게시판글목록</a></li>
        </ul>
      </li> 
             
       
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
    	<c:when test="${loginstate==true }">
    		<li><a href="#"><span class="glyphicon glyphicon-user"></span>${id}님!!반갑습니다</a></li>
      		<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>    	
    	</c:when>
    	<c:otherwise>
    		<li><a href="minput"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
      		<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
    	</c:otherwise>
    
    </c:choose>
      
    </ul>
  </div>
</nav>
  
</body>
</html>