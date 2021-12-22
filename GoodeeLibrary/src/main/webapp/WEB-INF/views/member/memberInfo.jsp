<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<div id="container">
	<p>별명 : ${mvo.nickname}</p>
	
	<input type="button" class="btn btn-default" id="login" name="login" value="회원정보 수정" onclick="loginCheck()">
	<input type="button" class="btn btn-default" value="돌아가기" onclick="javascript:history.back(-1)">
</div>
</body>
</html>