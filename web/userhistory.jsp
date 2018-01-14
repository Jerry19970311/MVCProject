<%@ page import="java.util.List" %>
<%@ page import="bean.QuestionHistory" %><%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/1/13
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<QuestionHistory> qh= (List<QuestionHistory>) request.getAttribute("histories");
    int count=qh.size();
%>
<table border="1">
    <tr>
        <td>
            编号
        </td>
        <td>
            得分
        </td>
        <td>
            答题时间
        </td>
        <td>
            ID
        </td>
    </tr>
    <%
        for(int i=0;i<count;i++){
    %>
    <tr>
        <td>
            <%=qh.get(i).getId()%>
        </td>
        <td>
            <%=qh.get(i).getGrade()%>
        </td>
        <td>
            <%=qh.get(i).getTime()%>
        </td>
        <td>
            <%=qh.get(i).getUser()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
