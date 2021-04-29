<%--
  Created by IntelliJ IDEA.
  User: 15996
  Date: 2021/4/7
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%@include file="header.jsp"%>
<%
    String mas=null;
    if((mas= (String) request.getAttribute("msg") )!=null)
    {
        out.println("Username or Password is wrong");
    }
%>
<form method="post" action="login">
    <h1>Login</h1>
    username:<input required="required" type="text" name="username" placeholder="name"><br/>
    password:<input required="required" type="password" name="password" placeholder="password" minlength="8"><br/>
    <input required="required" type="submit" value="Login"/>
    </form>
<%@include file="footer.jsp"%>
</body>
</html>
