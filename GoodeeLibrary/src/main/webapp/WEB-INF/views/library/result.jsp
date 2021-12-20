<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${loanVo != null}">
	<p>해당 도서는 대출중입니다.</p><br>
</c:if>

<c:if test="${il == 1}">
	<p>도서 대출완료</p><br>
</c:if>
<c:if test="${ibd == 1}">
	<p>도서 상세정보 추가</p><br>
</c:if>

<c:if test="${ir == 1}">
	<p>도서 예약완료</p><br>
</c:if>
<c:if test="${udr == 1}">
	<p>도서 예약 업데이트</p><br>
</c:if>

<c:if test="${lists != null}">
	<c:forEach var="vo" items="${lists}">
		${vo}<br>
	</c:forEach>
</c:if>


</body>
</html>