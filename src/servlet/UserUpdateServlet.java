package servlet;

import handler.SelfHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserUpdateServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName=req.getParameter("name");
        if(req.getParameter("cancel")!=null){
            req.getRequestDispatcher("/true.jsp").forward(req,resp);
            return;
        }
        if((req.getParameter("yes")!=null)&&(newName.equals(""))){
            req.setAttribute("error","用户名不可以为空！");
            req.getRequestDispatcher("/changeuser.jsp").forward(req,resp);
            return;
        }
        if(newName.length()>10){
            req.setAttribute("error","用户名必须在10个字符以内！");
            req.getRequestDispatcher("/changeuser.jsp").forward(req,resp);
            return;
        }
        try {
            SelfHandler.changeName((String)req.getSession().getAttribute("id"),newName);
            req.getSession().setAttribute("name",newName);
            req.getRequestDispatcher("/true.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
