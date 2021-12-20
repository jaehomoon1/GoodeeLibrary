<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <li class="active"><a href="./notice.do">공지사항</a></li>
        <li><a href="./search_book.do">도서검색</a></li>
        <li><a href="#">도서반납</a></li>
        <li><a href="#">도서요청</a></li>
        <li><a href="./damagedBook.do">도서신고</a></li>
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
      <p><a href="./undamagedBookList.do">이용 가능 도서</a></p>
      <p><a href="./damagedBook.do">도서 훼손 신고</a></p>
      <p><a href="./damagedBookList.do">훼손 도서 목록</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1><b>공지사항</b></h1>
	<%-- <c:set var="len" value="${fn:length(lists)}"></c:set>
	TOTAL : ${len} --%>
	  <table class="table table-striped table-hover" style="margin-top : 20px">
	    <thead>
	      <tr>
	        <th>연번</th>
	        <th>제목</th>
	        <th>등록일</th>
	      </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="obj" items="${requestScope.lists}" varStatus="vs">
			    <c:if test="${obj.delflag eq 'N'}">
			      <tr>
			        <!-- len : total / - : 빼기 / vs : varStatus -->
			        <!-- index : 0부터 시작 / count : 1부터 시작 -->
			        <td>${len - vs.index}</td>
			        <td>${obj.id}</td>
			        <td>
			        	<!-- 
			        	regdate가 String일 경우 처리하는 방법 
			        	SQL문에서 TO_CHAR	
			        	// fmt:parseDate는 설정값을 var라는 id에 넣으면
			        	   fmt:formatDate에서 그 id값을 적용함, pattern은 default값에서 변경
			        	-->
			        	<fmt:parseDate var="id" value="${obj.regdate}" pattern="yyyy-MM-dd"/>
			        	<fmt:formatDate value="${id}" pattern="yyyy/MM/dd"/> 
			        </td>
			      </tr>
			    </c:if>
		    </c:forEach>
	    </tbody>
	  </table>
	  </div>
	</div>
</div>
<footer class="container-fluid text-center">
  <p>footer</p>
</footer>

</body>
</html>
