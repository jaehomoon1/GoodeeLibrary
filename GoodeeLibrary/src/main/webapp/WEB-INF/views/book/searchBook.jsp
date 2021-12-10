<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style type="text/css">
.green_window {
	display: inline-block;
	width: 366px;
	border: 3px solid #2db400;
}

.input_text {
	width: calc(100% - 14px);
	margin: 6px 7px;
	border: 0;
	font-weight: bold;
	font-size: 16px;
	outline: none;
}

.sch_smit {
	width: 54px;
	height: 40px;
	margin: 0;
	border: 0;
	vertical-align: top;
	background: #22B600;
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}

.sch_smit:hover {
	background: #56C82C;
}
</style>

<script type="text/javascript">
	function kakaobook(){
		var book = document.getElementById("book_name").value;
		location.href="./kakao_book.do?searchWord="+book;
	}
</script>

</head>
<body>


	<span class='green_window'> 
	<input type="text" id="book_name" class='input_text'>
	</span>
	<button id="search" class='sch_smit' onclick=kakaobook()>검색</button>
	<br>
	

	<c:forEach var="book" items="${kakaoBook.documents}">
	제목 : ${book.title}<br>
	저자 : ${book.authors}<br>
	내용 : ${book.contents}<br>
	이미지 : <img src="${book.thumbnail}">
		<br>

	</c:forEach>

</body>
</html>