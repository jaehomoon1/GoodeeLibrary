<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="./login.jsp" %>
<a href="./checkLoan.do?seq=1">도서가 대출중인지 확인</a><br>
<a href="./insertLoan.do?memSeq=${mvo.member_seq}&bookSeq=1">도서 대출하기</a><br>
<a href="./insertReservation.do?loanSeq=41">도서 예약하기</a><br>
<a href="./memberLoanList.do?id=${mvo.id}">회원이 대출한 도서목록</a><br>
</body>
</html>