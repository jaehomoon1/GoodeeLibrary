<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/signup.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script type="text/javascript" src="./js/signup.js"></script>
</head>
<body>
<div id="container">
	<div id="title">
		<!-- <img alt="logo" src="img/logo.png"> -->
	</div>
	
	<input type="hidden" id="chkval" value="0">
	
	<form action="./signup.do" method="post" onsubmit="return check()">
		<div id="info">
			<div id="leftInfo"></div>
				
			<div id="centerInfo">
				아이디<br><input type="text" id="id" name="id" placeholder="아이디" required><br>
				<span id="result"></span>
				비밀번호<br>
				<input type="password" id="password" name="password" placeholder="비밀번호" required><br>
				비밀번호 확인<br>
				<input type="password" id="passChk" placeholder="비밀번호 확인" required><br>
				이름<br>
				<input type="text" id="name" name="name" placeholder="성명" required><br>
				닉네임<br>
				<input type="text" id="nickname" name="nickname" placeholder="Nickname" required><br>
				전화번호<br>
				<input type="tel" id="phone" name="phone" placeholder="전화번호" required>
			</div>
			
			<div id="button">
				<input type="submit" value="동의하고 회원가입">
				<input type="button" value="돌아가기" onclick="javascript:history.back(-1)">
			</div>
			
		</div>
		
	</form>
	
</div>

</body>
</html>