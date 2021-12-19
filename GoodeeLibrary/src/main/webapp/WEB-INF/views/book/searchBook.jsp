<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> <!-- w3cschool css -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>책검색</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
	height: 44px;
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
		document.getElementById("book_name").focus;
	}
	
	function Enter_Check(){
        // 엔터키의 코드는 13입니다.
	if(event.keyCode == 13){
		kakaobook();  // 실행할 이벤트
		}
	}
	 function bookdetail(a){
		 	var step;
		 	
		 	for (step = 1; step<11; step++){
		 		if(a==step){
		 			document.getElementById("bookdetail_form"+step).submit();
		 		}
		 	}	 	
	 }   
	
</script>

</head>
<body>

<div class="container">


	<span class='green_window'> 
	<input type="text" id="book_name" name="book_name" class='input_text' placeholder="책 제목을 입력해주세요." onkeydown="Enter_Check();" value="${book_name}">
	</span>
	<button id="search" class='sch_smit' onclick=kakaobook()>검색</button>

	
	<table class="table">
	   <c:forEach var="book" varStatus="status" items="${kakaoBook.documents}">
    <thead>
      <tr>
        <th>이미지</th>
        <th>제목</th>
        <th>저자</th>
        <th>내용</th>
      </tr>
    </thead>
    
 	<tbody>
      
   
      <tr>
      	
       <td>
       <form action="./bookdetail.do" method="post" id="bookdetail_form${status.count}">
       <input type="hidden" value="${book.thumbnail}" name="thumbnail">
       <input type="hidden" value="${book.title}" name="title">
       <input type="hidden" value="${book.contents}" name="contents">
       <input type="hidden" value="${book.datetime}" name="datetime">
       <input type="hidden" value="${book.isbn}" name="isbn">
       <input type="hidden" value="${book.price}" name="price">
       <input type="hidden" value="${book.publisher}" name="publisher">
       <input type="hidden" value="${book.authors}" name="authors">
       </form>
       		<a href="#" onclick="bookdetail(${status.count})">
       		<img src="${book.thumbnail}">
       		</a>
       </td>
        <td><a href="#" onclick="bookdetail(${status.count})">${book.title}</a></td>
        <td>${book.authors}</td>
        <td> ${book.contents}</td>
      </tr>
	</c:forEach>
 	 </tbody>
	</table>
	
</div>
</body>
</html>