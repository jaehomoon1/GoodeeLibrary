<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <title>지식을 긷는 우물, 책우물</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./css/notice.css"></script>
  <link rel="shortcut icon" href="resources/imgs/favicon.ico" type="image/x-icon">
  <link rel="icon" href="resources/imgs/favicon.ico" type="image/x-icon" sizes="16x16">
</head>
<style>
	.navbar {
		background: #abecd6;
		border: none;
	}
	#logo {
		width: 100px;
		height: 100px;
		margin-top: 8px;
		margin-left: -10px;
		margin-bottom: -8px;
	}
	#myNavbar ul li a {
		color: #5d4157;
		text-align: center;	
		height: 100px;
		display: flex;
		align-items: center;
		font-weight: bolder;
	}
	#myNavbar ul li a:hover {
		color: white;
		background: #4dd0a3;
	}
	#myNavbar ul li span {
		margin-top: -5px;
		margin-right: 10px;
	}
	#nav1 .navbar-nav>.active>a{
		color: white;
		background: #49c69c;
	}
</style>
<body>

<%@ include file="./navbar.jsp" %>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="./damagedBook.do">도서 훼손 신고</a></p>
      <p><a href="./damagedBookList.do">훼손 도서 목록</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1><b>공지사항</b></h1>
	</div>
	</div>
</div>
<footer class="container-fluid text-center">
  <p>곧 삭제될 페이지입니다.</p>
</footer>

</body>
</html>
