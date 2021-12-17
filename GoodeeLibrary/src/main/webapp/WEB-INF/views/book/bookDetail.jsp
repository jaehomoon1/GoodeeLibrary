<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./insertBook.do" method="post">
 		
 	<table class="table">
    <thead>
      <tr>
        <th>이미지</th>
        <th>제목</th>
        <th>저자</th>
        <th>내용</th>
        <th>출판사</th>
        <th>출판날짜</th>
        <th>isbn</th>
        <th>가격</th>
      </tr>
    </thead>
    
 	<tbody>
      <tr>
       <td><img src="${thumbnail}"></td>
        <td>${title}</td>
        <td>${authors}</td>
        <td> ${contents}</td>
        <td>${publisher}</td>
         <td>${datetime}</td>
        <td>${isbn}</td>
        <td> ${price}</td>
      </tr>
 	 </tbody>
	</table>
	<select name="book_count">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select>
	<input type="submit" value="등록하기">
	</form>
</body>
</html>