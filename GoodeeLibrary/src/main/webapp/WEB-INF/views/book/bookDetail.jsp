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
function kakaobook(){
	
	var book = document.getElementById("title").value;
	location.href="./kakao_book.do?searchWord="+book;
	id.focus();
}

</script>
<title>Insert title here</title>
</head>
<body>
	<form action="./insertBook.do" method="post" onsubmit="kakaobook()">
 		<input type="hidden" value="${thumbnail}" name="thumbnail">
       	<input type="hidden" value="${title}" name="title" id="title">
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
        <td>${contents}</td>
        <td>${publisher}</td>
         <td>${datetime}</td>
        <td>${isbn}</td>
        <td> ${price}</td>
      </tr>
 	 </tbody>
	</table>
	<select name="book_count">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
	</select>
	<input type="submit" value="등록하기" class="btn btn-info">
	<a href="javascript:history.back()" class="btn btn-info">취소</a>
	</form>
</body>
</html>