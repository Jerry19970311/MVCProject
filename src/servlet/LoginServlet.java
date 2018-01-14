package servlet;

import DAO.IllegalInputExpection;
import handler.HistorySelect;
import handler.LoginErrorExpection;
import handler.LoginHandler;
import bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/rooterror.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String id= (String) req.getParameter("id");
        String password=(String)req.getParameter("password");
        System.out.println(id+"\n"+password);
        if(id==null||password==null){
            //resp.sendRedirect("error.jsp");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
        try {
            Person person= LoginHandler.getPerson(id,password);
            if(HistorySelect.isAnswered(id)){
                req.setAttribute("answered",true);
            }
            req.getSession().setAttribute("id",person.getId());
            req.getSession().setAttribute("name",person.getName());
            int power=person.getPower();
            if(power==0){
                req.getSession().setAttribute("power","普通用户");
                req.getRequestDispatcher("/true.jsp").forward(req,resp);
            }else if(power==1){
                req.getSession().setAttribute("power","普通管理员");
                req.getRequestDispatcher("/true.jsp").forward(req,resp);
            }else if(power==2){
                req.getSession().setAttribute("power","超级管理员");
                req.getRequestDispatcher("/true.jsp").forward(req,resp);
            }else{
                req.getRequestDispatcher("/error.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (LoginErrorExpection loginErrorExpection) {
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        } catch (IllegalInputExpection illegalInputExpection) {
            illegalInputExpection.printStackTrace();
        }
    }
}
