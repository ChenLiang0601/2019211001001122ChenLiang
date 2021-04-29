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
    if((mas= (String) request.getAttribute("message") )!=null)
    {
        response.getWriter().write("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<%
   Cookie[] allCookie= request.getCookies();
   String username="",password="",rememberMeVale="";
   if(allCookie!=null){
       for (Cookie c:allCookie){
           if (c.getName().equals("cUsername")){
               username=c.getValue();
           }
           if (c.getName().equals("cPassword")){
               password=c.getValue();
           }
           if (c.getName().equals("cRememberMe")){
               rememberMeVale=c.getValue();
           }
       }
   }
%>
<form method="post" action="login">
    <h1>Login</h1>
    username:<input required="required" type="text" name="username" value="<%=username%>" placeholder="name"><br/>
    password:<input required="required" type="password" name="password" value="<%=password%>" placeholder="password" minlength="8"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1")?"checked":""%> />RememberMe<br/>
    <input required="required" type="submit" value="Login"/>
    </form>
<%@include file="footer.jsp"%>
</body>
</html>
