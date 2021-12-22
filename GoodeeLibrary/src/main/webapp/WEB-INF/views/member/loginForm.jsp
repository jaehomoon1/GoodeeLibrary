<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script type="text/javascript" src="./js/login.js"></script>
  <style type="text/css">
  	#container{
  		padding: 100px;
  	}
  	#buttons{
  		text-align: center;
  		
  	}
  </style>
</head>
<body>

<div id="container">
	<h2>로그인</h2>
	<form id="form" method="post">
		<div class="form-group">
			<label for="id">아이디 : </label>
			<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력해주세요" required>
		</div>
		<div class="form-group">
			<label for="pw">비밀번호 : </label>
			<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력해주세요" onkeyup="enterKey()">
		</div>
		<div id="buttons">
			<input type="button" class="btn btn-default" id="login" name="login" value="로그인" onclick="loginCheck()">
			<input type="button" class="btn btn-default" id="signUp" value="회원가입">
		</div>
	</form>

</div>

</body>
</html>