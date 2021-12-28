<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>지식을 긷는 우물, 책우물</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<link href="./css/navbar.css" rel="stylesheet">
<link rel="shortcut icon" href="resources/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="resources/imgs/favicon.ico" type="image/x-icon" sizes="16x16">

</head>
<body>

<%@ include file="../book/navbar.jsp" %>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
	<div class="col-sm-8 text-left"> 
      <h1><b>신고글 작성</b></h1><br>
      <form id="frm" action="./insertBoard.do" method="post" >
		<div id="container" class="table-response">
			<table class="table">
				<tbody>
					<tr>
						<th>작성자</th>
						<td>${mvo.id}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" id="title" name="title" style="width:63%"/></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea style="resize: none" rows="15" cols="100" id="content" name="content"></textarea>
						</td>
					</tr>	        
					<tr>
			            <td colspan="2" align="center">
			                <input type="submit" class="btn btn-success" value="작성"/>
			                <input type="button" class="btn btn-danger" value="취소" onclick="history.back()"/>
			            </td>
			        </tr>
				</tbody>
			</table>
		</div>
	 </form>
   </div>
   </div>
</div>

</body>
</html>

