<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>홈페이지 디자인</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  .jumbotron {
    color: #5d4157;
    background: #abecd6;
  }
  .logo{
  	width: 150px;
  	height: 150px;
  	margin-bottom: -30px;
  }
  h1{margin-bottom: -10px;}
  h3{margin-bottom: 30px;}
  </style>
</head>
<body>
<div class="jumbotron text-center">
  <img class="logo" alt="logo" src="./imgs/logo.png" onclick="location.href='./home.do'" style="cursor: pointer;">
  <h1><b>책 우물</b></h1> 
  <h3><b>지식을 긷는 우물</b></h3> 
  <form class="form-inline">
    <div class="input-group">
      <input type="email" class="form-control" size="50" placeholder="검색하실 도서명을 입력해주세요" required>
      <div class="input-group-btn">
        <button type="button" class="btn btn-success">도서 검색</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>