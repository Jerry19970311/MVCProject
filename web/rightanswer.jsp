<%@ page import="java.util.List" %>
<%@ page import="bean.Question" %><%--
  Created by IntelliJ IDEA.
  User: XZL
  Date: 2018/1/14
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Question> questions=(List<Question>)request.getAttribute("questions");
    int count=questions.size();
%>
<table border="1">
    <tr>
        <td>
            题目
        </td>
        <td>
            选项
        </td>
        <td>
            正确答案
        </td>
    </tr>
    <%
        for(int i=0;i<count;i++){
            Question question=questions.get(i);
    %>
    <tr>
        <td>
            <%=question.getText()%>
        </td>
        <td>
            <%
                if(question.getStyle()==1){
            %>
            A.<%=question.getAnswer1()%>
            B.<%=question.getAnswer2()%>
            <%
                if(question.getAnswer3()!=null){
            %>
            C.<%=question.getAnswer3()%>
            <%
                if(question.getAnswer4()!=null){
            %>
            D.<%=question.getAnswer4()%>
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
            A.<%=question.getAnswer1()%>
            B.<%=question.getAnswer2()%>
            <%
                if(question.getAnswer3()!=null){
            %>
            C.<%=question.getAnswer3()%>
            <%
                if(question.getAnswer4()!=null){
            %>
            D.<%=question.getAnswer4()%>
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
        <td>
            <%=question.getRightAnswer()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
