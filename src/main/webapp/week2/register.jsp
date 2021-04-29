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
    <title>week2 homework</title>
</head>
<body>

<form method="post">
    New Use Registration<br/>
    <input required="required" type="text" name="name" placeholder="name"><br/>
    <input required="required" type="password" name="password" placeholder="password" minlength="8"><br/>
   <input required="required" type="email" name="email" placeholder="Email"><br/>
    Gender: <input required="required" type="radio" name="sex" value="mail">Male
   <input required="required" type="radio" name="sex" value="female">Female<br/>
    <input required="required" type="text" name="date" placeholder="Date of Birth (yyyy-mm-dd)" pattern="\d\d\d\d-\d\d-\d\d"><br/>
    <input required="required" type="submit" value="register"/>

</form>

</body>
</html>
