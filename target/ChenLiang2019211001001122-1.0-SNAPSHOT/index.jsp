<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%@include file="header.jsp"%>
<h1><%= "Welcome to my Home Page" %>
</h1>
<br/>
<form method="get"  target="_blank" action="${pageContext.request.contextPath}/search">
<input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="sougou">Sougo</option>
    </select>
    <input type="submit" value="Search">
</form>
<a href="hello-servlet">Student info Servlet-week2</a>
<br/>
<a href="Life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">Config.parameter</a>
<br/>
<a href="register.jsp">Register JDBC-week4</a>
<br/>
<a href="index.jsp">Include-week5</a>
<br/>
<a href="login.jsp">Login-week5</a>
<%@include file="footer.jsp"%>
</body>
</html>