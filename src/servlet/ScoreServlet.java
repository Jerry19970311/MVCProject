package servlet;

import bean.Question;
import handler.QuestionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ScoreServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果用户单击的是取消，则不做任何操作直接回到用户主界面。
        if(req.getParameter("can")!=null){
            req.getRequestDispatcher("/true.jsp").forward(req,resp);
        }
        try {
            QuestionHandler.getquestions();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int count=QuestionHandler.questions.size();
        for(int i=0;i<count;i++){
            Question question=QuestionHandler.questions.get(i);
            String sign=question.getSign();
            int style=question.getStyle();
            if(style==1){
                String ans=req.getParameter(sign)+"";
                QuestionHandler.singleAnswer.put(i,ans);
            }
            if(style==2){
                String[] anss=req.getParameterValues(sign);
                System.out.println(anss);
                QuestionHandler.complexAnswer.put(i,anss);
            }
        }
        int grade=QuestionHandler.score();
        String user= (String) req.getSession().getAttribute("id");
        try {
            QuestionHandler.summitGrade(grade,user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/true.jsp").forward(req,resp);
        //System.out.println(grade+"------------------------------------------------------------");
    }
}
