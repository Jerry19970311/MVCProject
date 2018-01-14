<%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/1/13
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
您的ID:<%=session.getAttribute("id")%>
<br/>
您的用户名:<%=session.getAttribute("name")%>
<br/>
您的权限:<%=session.getAttribute("power")%>
<br/>
请输入新的用户名：
<br/>
<form action="userUpdateServlet" name="form" method="post">
    <input type="text" name="name">
    <%
        String error=(String)request.getAttribute("error");
        if(error!=null){
            out.print(error);
        }
    %>
    <br/>
    <input type="submit" name="yes" value="确定">
    <input type="submit" name="cancel" value="取消">
</form>
</body>
</html>
