<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- w3cschool css -->
<link rel="stylesheet" href="./css/Book.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		var loanBtn = document.getElementById('loanBtn');
		if(${checkBookSeq} && !${mvo eq null} && ${mvo.auth eq 'U'}){
			loanBtn.removeAttribute("disabled");
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="./insertLoan.do" method="post">
 		<input type="hidden" value="${thumbnail}" name="thumbnail">
       	<input type="hidden" value="${title}" name="title">
       	<input type="hidden" value="${contents}" name="contents">
       	<input type="hidden" value="${datetime}" name="datetime">
       	<input type="hidden" value="${isbn}" name="isbn">
       	<input type="hidden" value="${price}" name="price">
       	<input type="hidden" value="${publisher}" name="publisher">
       	<input type="hidden" value="${authors}" name="authors">
 	<table class="table">
    <thead>
      <tr>
        <th>이미지</th>
        <th>제목</th>
        <th>저자</th>
        <th>내용</th>
        <th>출판사</th>
        <th>출판날짜</th>
        <th>isbn</th>
        <th>가격</th>
      </tr>
    </thead>
    
 	<tbody>
      <tr>
       <td><img src="${thumbnail}"></td>
        <td>${title}</td>
        <td>${authors}</td>
        <td> ${contents}</td>
        <td>${publisher}</td>
         <td>${datetime}</td>
        <td>${isbn}</td>
        <td> ${price}</td>
      </tr>
 	 </tbody>
	</table>
	<input type="text" value="${countBook}" readonly="readonly">
	<input type="submit" value="도서대출" id="loanBtn" class="btn btn-info" disabled="disabled">
	<a href="javascript:history.back()" class="btn btn-info">취소</a>
	</form>
</body>
</html>