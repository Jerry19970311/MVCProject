<%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2017/12/29
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userServlet" name="from" method="post">
    <input type="submit" name="a" value="a">
    <%
        if(request.getAttribute("answered")!=null){
    %>
    <input type="submit" name="b" value="b">
    <input type="submit" name="x" value="x">
    <%
        }
    %>
    <input type="submit" name="c" value="c">
    <input type="submit" name="d" value="d">
    <input type="submit" name="e" value="e">
</form>
</body>
</html>
