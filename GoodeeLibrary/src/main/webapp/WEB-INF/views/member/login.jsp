<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GoodeeLibrary</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${mvo == null}">
	      <li><a href="./loginForm.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      </c:if>
      <c:if test="${mvo != null}">
          <li><a href="#">${mvo.id} 님</a></li>
	      <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </c:if>
    </ul>
  </div>
</nav>
</body>
</html>