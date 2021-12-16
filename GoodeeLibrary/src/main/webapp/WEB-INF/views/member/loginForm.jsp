<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
	<form action="./login.do" method="post">
		<div id="id" class="form-group">
			<label for="id">아이디 : </label>
			<input type="text" class="form-control" name="id" placeholder="아이디를 입력해주세요" required>
		</div>
		<div id="pw" class="form-group">
			<label for="pw">비밀번호 : </label>
			<input type="password" class="form-control" name="pw" placeholder="비밀번호를 입력해주세요" required>
		</div>
		<div id="buttons">
			<input type="submit" class="btn btn-default" value="로그인">
			<input type="button" class="btn btn-default" value="회원가입" onclick="location.href='./signupForm.do'">
		</div>
	</form>

</div>

</body>
</html>