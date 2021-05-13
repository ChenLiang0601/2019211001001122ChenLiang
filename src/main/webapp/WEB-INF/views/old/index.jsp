<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%@include file="header.jsp"%>
<h1><%= "Welcome to my Home Page" %>
</h1>
<br/>

<a href="hello-servlet">Hello servlet</a>

<%@include file="footer.jsp"%>
</body>
</html>