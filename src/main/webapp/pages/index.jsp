<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>
     <c:choose>
         <c:when test="${isLogged}">
             <h2 align="center"> Hello ${user.email} welcome to Spring Boot JSP!</h2>
         </c:when>
         <c:otherwise>
             <h2 align="center"> Hello guys, welcome to Spring Boot JSP!</h2>
             <a href="/auth/login">Click here to login</a>
         </c:otherwise>
     </c:choose>
     <c:if test="${isOauth2}">
        <h2 align="center" color="green"> This is Oauth2 authentication!!!</h2>
     </c:if>
     <c:if test="${isNormal}">
         <h2 align="center" color="gray"> This is normal user</h2>
      </c:if>
</body>
</html>