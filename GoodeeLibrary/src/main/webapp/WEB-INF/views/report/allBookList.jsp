<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <script type="text/javascript" src="./css/damagedBook.css"></script>
  <link rel="shortcut icon" href="resources/imgs/favicon.ico" type="image/x-icon">
  <link rel="icon" href="resources/imgs/favicon.ico" type="image/x-icon" sizes="16x16">
</head>

<body>

<%@ include file="../book/navbar.jsp" %>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="./boardList.do">도서 훼손 신고</a></p>
      <c:if test="${mvo.auth eq 'A'}">
    	<p><a href="./damagedBookList.do">훼손 도서 목록</a></p>
       	<p><a href="./undamagedBookList.do">미훼손 도서 목록</a></p>
       	<p><a href="./allBookList.do">전체 도서 목록</a></p>
      	<p><a href="./mailForm.do">제재 이메일 발송</a></p>
      </c:if>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1><b>신고 게시판</b></h1>
      <div class="container">
		  <h2>전체 도서 목록</h2>         
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>연번</th>
		        <th>제목</th>
		        <th>저자</th>
		        <th>출판사</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:set var="len" value="${fn:length(blist)}"></c:set>
			    <c:forEach var="blist" items="${requestScope.blist}" varStatus="vs"> 
			      <tr>
			        <td>${len - vs.index}</td>
			        <td>${blist.title}</td>
			        <td>${blist.authors}</td>
			        <td>${blist.publisher}</td>
			      </tr>
				</c:forEach>
		    </tbody>
		  </table>
		</div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p></p>
</footer>

</body>
</html>
