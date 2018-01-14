<%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/1/14
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="passwordChangeServlet" name="form" method="post">
    <%
        String error=(String)request.getAttribute("error");
        if(error!=null){
            out.println("发生错误:"+error);
        }
    %>
    请输入原来的密码：
    <br/>
    <input type="text" name="old">
    <br/>
    请输入新密码：
    <br/>
    <input type="text" name="new">
    <br/>
    请确认新密码：
    <br/>
    <input type="text" name="newn">
    <br/>
    <input type="submit" name="yes" value="确定">
    <input type="submit" name="cancel" value="取消">
</form>
</body>
</html>
