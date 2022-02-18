<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link href="../Login.css" rel="stylesheet" type="text/css">
</head>
<body>
     <h2 align="center">Signup</h2>
     <div className="social-signup">
         <a className="btn btn-block social-btn google" href='http://localhost:8080/oauth2/authorize/google?redirect_uri=http://localhost:8082/auth/oauth2/redirect'>
             <img src="/img/google-logo.png" alt="Google" /> Log in with Google</a>
         <a className="btn btn-block social-btn facebook" href='#'>
             <img src="/img/fb-logo.png" alt="Facebook" /> Log in with Facebook</a>
         <a className="btn btn-block social-btn github" href='#'>
             <img src="/img/github-logo.png" alt="Github" /> Log in with Github</a>
     </div>
     <form:form action="/auth/signup" method="post" modelAttribute="user">
         <div className="form-item">
             <form:label path="name">Name: </form:label> <form:input className="form-control" type="text" path="name"/>
         </div>
         <div className="form-item">
            <form:label path="email">Email: </form:label> <form:input className="form-control" type="text" path="email"/>
         </div>
         <div className="form-item">
            <form:label path="password">Password: </form:label> <form:input className="form-control" path="password"/>
         </div>
         <div className="form-item">
            <input className="btn btn-block btn-primary" type="submit" value="submit"/>
         </div>
     </form:form>
</body>
</html>