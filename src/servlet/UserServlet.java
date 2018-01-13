package servlet;

import bean.Question;
import bean.QuestionHistory;
import handler.HistorySelect;
import handler.QuestionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("a")!=null){
            try {
                QuestionHandler.getquestions();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            List<Question> questions= QuestionHandler.questions;
            req.setAttribute("qs",questions);
            req.getRequestDispatcher("/questions.jsp").forward(req,resp);
        }
        if(req.getParameter("b")!=null){
            String name= (String) req.getSession().getAttribute("id");
            try {
                List<QuestionHistory> histories= HistorySelect.getHistories();
                req.setAttribute("histories",histories);
                req.getRequestDispatcher("/userhistory.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(req.getParameter("c")!=null){
            System.out.println("c");
        }
    }
}
