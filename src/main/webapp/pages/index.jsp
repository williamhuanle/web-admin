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
         <div align="center"><a align="center" href="/auth/login">Click here to login</a></div>
        </c:otherwise>
    </c:choose>
    <c:if test="${isOauth2}">
        <h2 align="center" style="color: red;"> This ${user.email} is Oauth2 authentication!!!</h2>
    </c:if>
    <c:if test="${isNormal}">
        <h2 align="center" style="color: gray;"> This ${user.email} is normal user</h2>
    </c:if>
    <c:if test="${isRegistered}">
        <h2 align="center" style="color: gray;"> User ${user.email} is Registered</h2>
    </c:if>
    <c:if test="${isLogged}">
        <style type="text/css">
        .tg  {border-collapse:collapse;border-color:#aabcfe;border-spacing:0; margin-left: auto; margin-right: auto;}
        .tg td{background-color:#e8edff;border-color:#aabcfe;border-style:solid;border-width:1px;color:#669;
          font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
        .tg th{background-color:#b9c9fe;border-color:#aabcfe;border-style:solid;border-width:1px;color:#039;
          font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
        .tg .tg-ikmv{background-color:#cbcefb;text-align:left;vertical-align:top}
        .tg .tg-0lax{text-align:left;vertical-align:top}
        </style>
        <table class="tg">
        <thead>
          <tr>
            <th class="tg-ikmv">employeeId</th>
            <th class="tg-ikmv">firstName</th>
            <th class="tg-ikmv">title</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${employees}" var="emp" >
              <tr>
                <td class="tg-0lax">${emp.firstName}</td>
                <td class="tg-0lax">${emp.lastName}</td>
                <td class="tg-0lax">${emp.title}</td>
              </tr>
          </c:forEach>
        </tbody>
        </table>
    </c:if>
</body>
</html>
