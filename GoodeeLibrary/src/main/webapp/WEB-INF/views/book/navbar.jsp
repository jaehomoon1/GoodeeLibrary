<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- w3cschool css -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="./css/navbar.css" rel="stylesheet">

<body>
<nav class="navbar navbar-inverse" id="nav1">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <div>
      	<img id="logo" class="logo" alt="logo" src="./imgs/logo.png" onclick="location.href='./bookList.do'" style="cursor: pointer;">
      </div>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      	<c:if test="${mvo != null}">
	        <li><a href="./bookList.do">도서검색</a></li>
      	</c:if>
      	<c:if test="${mvo.auth eq 'A'}">
	        <li><a href="./search_book.do">도서등록</a></li>
	        <li><a href="./boardList.do">도서신고</a></li>
      	</c:if>
        <c:if test="${mvo.auth eq 'U'}">
	        <li><a href="./returnBookForm.do">도서반납</a></li>
	        <li><a href="#">도서요청</a></li>
	        <li><a href="./boardList.do">도서신고</a></li>
        </c:if>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       	 <c:if test="${mvo == null}">
		      <li><a href="./loginForm.do"><span class="glyphicon glyphicon-user"></span>로그인</a></li>
	      </c:if>
	      <c:if test="${mvo != null}">
	          <li><a href="./memberInfo.do">${mvo.nickname} 님 (${(mvo.auth eq "U")?"사용자":"관리자"})</a></li>
		      <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
	      </c:if>
      </ul>
    </div>
  </div>
</nav>
</body>