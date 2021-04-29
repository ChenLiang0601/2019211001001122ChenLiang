<%@ page import="com.ChenLiang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 15996
  Date: 2021/4/14
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<% User user=(User) session.getAttribute("user");%>
<h1>User Info</h1>
<table>
    <tr>
        <td>ID</td><td><%=user.getId()%></td>
    </tr>
    <tr>
        <td>Username</td><td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>Password</td><td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email</td><td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender</td><td><%=user.getSex()%></td>
    </tr>
    <tr>
        <td>Birthdate</td><td><%=user.getBirthday()%></td>

    </tr>
</table>
<%@include file="footer.jsp"%>
