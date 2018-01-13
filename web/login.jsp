<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2017/11/13
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="loginServlet" name="form" method="post">
    name:<input type="text" name="id">
    <br/>
    password:<input type="text" name="password">
    <br/>
    <input type="submit" name="Enter" value="登录">
</form>
</body>
</html>
