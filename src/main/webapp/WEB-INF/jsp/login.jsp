
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log in to your account</title>
    <base href="${pageContext.request.contextPath}">
  </head>
  <body>
    <header>
      <h1>Login</h1>
    </header>
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
      <table border="1">
        <tr>
      <td>
      <div class="error">
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
      </div>
      </td>
        </tr>
      </table>
      <br>
    </c:if>
    <form action="/login" method="post">
      <div><label> Username: <input type="text" name="username"/> </label></div>
      <br>
      <div><label> Password: <input type="password" name="password"/> </label></div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <div class="stage">
        <br>
        <input type="submit" class="btn" value="Login"/>
      </div>
    </form>
  </body>
</html>
