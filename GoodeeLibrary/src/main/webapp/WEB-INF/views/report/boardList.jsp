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
  <script type="text/javascript" src="./css/damagedBook.css"></script>
  <script type="text/javascript" src="./js/paging.js?ver=1"></script>
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
      <h1><b>신고게시판</b></h1><br>
      <div id="topmenu" style="display: flex; justify-content: space-between;">
		TOTAL : ${paging.total} 
		<div id="select" align="right">
			<span>
				<select class="btn btn-default" id="listCount" name="listCount" onchange="listCnt()">
					<option >게시글 수 변경</option>
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
				</select>
			</span>
		</div>
	</div>
	<input class="btn btn-primary" type="button" value="게시글 작성" onclick="location.href='./insertBoardForm.do'">
	  <table class="table table-striped table-hover" style="margin-top : 20px">
	    <thead>
	      <tr>
	        <th>연번</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>등록일</th>
	      </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="lists" items="${requestScope.lists}">
			    <c:if test="${lists.delflag eq 'N'}">
			      <tr>
			        <td>${paging.total - lists.rnum + 1}</td>
			        <td><a href="./detailBoard.do?board_seq=${lists.board_seq}">${lists.title}</a></td>
			        <td>${lists.id}</td>
			        <td>
			        	<fmt:parseDate var="date" value="${lists.regdate}" pattern="yyyy-MM-dd"/>
			        	<fmt:formatDate value="${date}" pattern="yyyy/MM/dd"/> 
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
  
	<form action="./paging.do" method="post" id="frmPaging">
		<!-- paging 처리 관련 값 >> PagingController getParameter -->
		<input type="hidden" name="index" id="index" value="${paging.index}">
		<input type="hidden" name="pageStartNum" id="pageStartNum" value="${paging.pageStartNum}">
		<input type="hidden" name="listCnt" id="listCnt" value="${paging.listCnt}">
		
		<div class="center">
			<ul class="pagination">
			
				<!-- <li><a href="#" onclick="pagePre(${paging.pageCnt+1}.${paging.pageCnt})">&laquo;</a></li> -->
				<li><a href="#" onclick="pageFirst()">&laquo;</a></li>
				<li><a href="#" onclick="pagePre(${paging.pageStartNum},${paging.pageCnt})">&lsaquo;</a></li>

				<!-- 페이지 번호 -->
				<c:forEach var="i" begin="${paging.pageStartNum}" end="${paging.pageLastNum}" step="1">	
					<li><a onclick="pageIndex(${i})">${i}</a></li>
				</c:forEach>
				
				<li><a href="#" onclick="pageNext(${paging.pageStartNum},${paging.total},${paging.listCnt},${paging.pageCnt})">&rsaquo;</a></li>
				<li><a href="#" onclick="pageLast(${paging.pageStartNum},${paging.total},${paging.listCnt},${paging.pageCnt})">&raquo;</a></li>
			</ul>
		</div>
	</form>
  
</footer>

</body>
</html>

