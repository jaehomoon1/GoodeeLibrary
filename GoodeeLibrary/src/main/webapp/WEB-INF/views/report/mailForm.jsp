<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지식을 긷는 우물, 책우물</title>
</head>
<body>

	<h2>메일 보내기</h2>
	<div id="container">
		<form action="./mailSender.do" method="post">
			<div align="center">
				<input type="text" name="tomail" placeholder="수신자 이메일 주소">
			</div>
			<div align="center">
				<input type="text" name="title" placeholder="메일 제목">
			</div>
			<div align="center">
				<textarea rows="20" cols="30"  name="content" placeholder="메일 내용"></textarea>
			</div>
			<div align="center">
				<input type="submit" value="메일 보내기">
			</div>
		</form>
	</div>
	
</body>
</html>