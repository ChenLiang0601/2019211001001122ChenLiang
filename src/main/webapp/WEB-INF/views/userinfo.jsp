<%@ page import="com.ChenLiang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 15996
  Date: 2021/4/14
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%--<%
   Cookie[] allCookie= request.getCookies();
   for (Cookie c:allCookie){
       out.println("<br>"+c.getName()+"---"+c.getValue());
   }
%>--%>
<%
    User u=(User)session.getAttribute("user");
%>
<table>
    <tr>
        <td>ID</td><td><%=u.getId()%></td>
    </tr>
    <tr>
        <td>Username</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender</td><td><%=u.getSex()%></td>
    </tr>
    <tr>
        <td>Birthdate</td><td><%=u.getBirthday()%></td>

    </tr>
</table>
<a href="updateUser">update</a>
<%@include file="footer.jsp"%>
