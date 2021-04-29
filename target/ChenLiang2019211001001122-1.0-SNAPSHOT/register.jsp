<%--
  Created by IntelliJ IDEA.
  User: 15996
  Date: 2021/3/13
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>week3 homework</title>
</head>
<body>

<%@include file="header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/register">
    New Use Registration<br/>
    ID:<input required="required" type="text" name="id" placeholder="id"><br/>
    username:<input required="required" type="text" name="Username" placeholder="name"><br/>
    password:<input required="required" type="password" name="password" placeholder="password" minlength="8"><br/>
    Email:<input required="required" type="email" name="email" placeholder="Email"><br/>
    Gender: <input required="required" type="radio" name="sex" value="male">Male
   <input required="required" type="radio" name="sex" value="female">Female<br/>
    Date of Birth:<input required="required" type="text" name="birthday" placeholder="Date of Birth (yyyy-mm-dd)" pattern="\d\d\d\d-\d\d-\d\d"><br/>
    <input required="required" type="submit" value="register"/>

</form>
<%@include file="footer.jsp"%>
</body>
</html>
