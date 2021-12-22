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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="resources/imgs/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="resources/imgs/favicon.ico" type="image/x-icon"
	sizes="16x16">
<style>
.jumbotron {
	color: #5d4157;
	background: #abecd6;
	margin-top: -20px;
}

.logo {
	width: 150px;
	height: 150px;
	margin-top: -30px;
	margin-bottom: -30px;
}

h1 {
	margin-top: 30px;
	margin-bottom: -10px;
}

h3 {
	margin-bottom: 50px;
}
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
<title>책검색</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
	var id = document.getElementById("book_name");
	
	function kakaobook(){
		
		var book = document.getElementById("book_name").value;
		location.href="./kakao_book.do?searchWord="+book;
		id.focus();
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

<%@ include file="./navbar.jsp" %>


	<div class="jumbotron text-center">
		<img class="logo" alt="logo" src="./imgs/logo.png"
			onclick="location.href='./home.do'" style="cursor: pointer;">
		<h1>
			<b>책 우물</b>
		</h1>
		<h3>
			<b>지식을 긷는 우물</b>
		</h3>
		<div class="form-inline">
			<div class="input-group">
				<input type="text" id="book_name" name="book_name" class="form-control" size="50"
					placeholder="검색하실 도서명을 입력해주세요" onkeydown="Enter_Check();" value="${book_name}">
				<div class="input-group-btn">
					<button id="search" class="btn btn-success" onclick=kakaobook()>도서 검색</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<table class="table">
			<c:forEach var="book" varStatus="status"
				items="${kakaoBook.documents}">
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
							<form action="./bookdetail.do" method="post"
								id="bookdetail_form${status.count}">
								<input type="hidden" value="${book.thumbnail}" name="thumbnail">
								<input type="hidden" value="${book.title}" name="title">
								<input type="hidden" value="${book.contents}" name="contents">
								<input type="hidden" value="${book.datetime}" name="datetime">
								<input type="hidden" value="${book.isbn}" name="isbn"> <input
									type="hidden" value="${book.price}" name="price"> <input
									type="hidden" value="${book.publisher}" name="publisher">
								<input type="hidden" value="${book.authors}" name="authors">
							</form> <a href="#" onclick="bookdetail(${status.count})"> <img
								src="${book.thumbnail}">
						</a>
						</td>
						<td><a href="#" onclick="bookdetail(${status.count})">${book.title}</a></td>
						<td>${book.authors}</td>
						<td>${book.contents}</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>