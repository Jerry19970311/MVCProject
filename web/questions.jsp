<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Question" %><%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2017/12/29
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Question> qs= (ArrayList<Question>) request.getAttribute("qs");
    int count=qs.size();
%>
<form action="scoreServlet" name="form" method="post">
<table border="1">
    <tr>
        <td>
            题目
        </td>
        <td>
            选项
        </td>
    </tr>
    <%
        for(int i=0;i<count;i++){
            Question question=qs.get(i);
    %>
    <tr>
        <td>
            <%=question.getText()%>
        </td>
        <td>
            <%
                if(question.getStyle()==1){
            %>
            <input type="radio" name="<%=question.getSign()%>" value="a"><%=question.getAnswer1()%>
            <input type="radio" name="<%=question.getSign()%>" value="b"><%=question.getAnswer2()%>
            <%
                if(question.getAnswer3()!=null){
            %>
            <input type="radio" name="<%=question.getSign()%>" value="c"><%=question.getAnswer3()%>
            <%
                if(question.getAnswer4()!=null){
            %>
            <input type="radio" name="<%=question.getSign()%>" value="d"><%=question.getAnswer4()%>
            <%
                }
            %>
            <%
                }
            %>
            <%}%>
            <%
                if(question.getStyle()==2){
            %>
            <input type="checkbox" name="<%=question.getSign()%>" value="a"><%=question.getAnswer1()%>
            <input type="checkbox" name="<%=question.getSign()%>" value="b"><%=question.getAnswer2()%>
            <%
                if(question.getAnswer3()!=null){
            %>
            <input type="checkbox" name="<%=question.getSign()%>" value="c"><%=question.getAnswer3()%>
            <%
                if(question.getAnswer4()!=null){
            %>
            <input type="checkbox" name="<%=question.getSign()%>" value="d"><%=question.getAnswer4()%>
            <%
                }
            %>
            <%
                }
            %>
            <%
                }
            %>
        </td>
    </tr>
    <%
        }
    %>
</table>
    <input type="submit" name="sub" value="提交">
    <input type="submit" name="can" value="退出">
</form>
</body>
</html>
