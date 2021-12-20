<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>지식을 긷는 우물, 책우물</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./css/damagedBook.css"></script>
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

<nav class="navbar navbar-inverse" id="nav1">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <div>
      	<img id="logo" class="logo" alt="logo" src="./imgs/logo.png" onclick="location.href='./home.do'" style="cursor: pointer;">
      </div>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="./notice.do">공지사항</a></li>
        <li><a href="./color.do">도서검색</a></li>
        <li><a href="#">도서반납</a></li>
        <li><a href="#">도서요청</a></li>
        <li class="active"><a href="./damagedBook.do">도서신고</a></li>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
       	 <c:if test="${mvo == null}">
		      <li><a href="./loginForm.do"><span class="glyphicon glyphicon-user"></span>로그인</a></li>
	      </c:if>
	      <c:if test="${mvo != null}">
	          <li><a href="#">${mvo.id} 님</a></li>
		      <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
	      </c:if>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="./damagedBook.do">도서 훼손 신고</a></p>
      <p><a href="./damagedBookList.do">훼손 도서 목록</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1><b>신고 게시판</b></h1>
      <div class="container">
		  <h2>도서 훼손 신고</h2>         
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>Firstname</th>
		        <th>Lastname</th>
		        <th>Email</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>John</td>
		        <td>Doe</td>
		        <td>john@example.com</td>
		      </tr>
		      <tr>
		        <td>Mary</td>
		        <td>Moe</td>
		        <td>mary@example.com</td>
		      </tr>
		      <tr>
		        <td>July</td>
		        <td>Dooley</td>
		        <td>july@example.com</td>
		      </tr>
		    </tbody>
		  </table>
		</div>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>하단부</p>
</footer>

</body>
</html>
