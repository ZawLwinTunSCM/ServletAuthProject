<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/jsp/common/header.jsp"%>
<html>
<head>
<title>User Register</title>
</head>
<body class="d-flex align-items-center justify-content-center">
  <div class="text-center ">
    <c:if test="${not empty sessionScope.name}">
      <h3 class="text-success">Welcome, ${sessionScope.name}!</h3>
      <br>
      <a href="<%=request.getContextPath()%>/logout" class="btn btn-danger">Logout</a>
    </c:if>
  </div>
</body>
</html>
