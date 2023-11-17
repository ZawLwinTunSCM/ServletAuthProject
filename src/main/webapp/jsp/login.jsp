<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/jsp/common/header.jsp"%>
<html>
<head>
<title>Login</title>
</head>
<body>
<body class="d-flex align-items-center justify-content-center">
<c:if test="${empty sessionScope.name}">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <h3 class="text-center">Login</h3>
          </div>
          <div class="card-body">
            <c:if test="${errorMsg != null}">
              <div class="alert alert-danger" id="errorMessage">${errorMsg}</div>
            </c:if>
            <c:if test="${logoutMsg != null}">
              <div class="alert alert-success" id="errorMessage">${logoutMsg}</div>
            </c:if>
            <form action="login" method="post">
              <div class="mb-3">
                <label for="username" class="form-label">Email:</label>
                <input type="text" class="form-control" id="email"
                  name="email" required>
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control"
                  id="password" name="password" required>
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div></c:if>
<c:if test="${not empty sessionScope.name}">
<%@ include file="/jsp/success.jsp"%>
</c:if>
</body>
</html>
