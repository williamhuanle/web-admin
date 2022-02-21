<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body align="center">
     <h2 align="center">Login</h2>
     <div align="center">
         <a href='http://localhost:8080/oauth2/authorize/google?redirect_uri=http://localhost:8082/auth/oauth2/redirect'>
             <img src="/img/google-logo.png" alt="Google" /> Log in with Google</a>
         <a href='#'>
             <img src="/img/fb-logo.png" alt="Facebook" /> Log in with Facebook</a>
         <a href='#'>
             <img src="/img/github-logo.png" alt="Github" /> Log in with Github</a>
     </div>
     <br/>
     <form:form action="/auth/login" method="post" modelAttribute="user">
         <div>
            <form:label path="email">Email: </form:label> <form:input type="text" path="email"/>
         </div>
         <div>
            <form:label path="password">Password: </form:label> <form:input path="password"/>
         </div>
         <div>
            <input type="submit" value="submit"/>
            <a href="/auth/signup">Sign up!</a>
         </div>
     </form:form>
</body>
</html>