package servlet;

import DAO.IllegalInputExpection;
import handler.SelfHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class PasswordChangeServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("cancel")!=null){
            req.getRequestDispatcher("/true.jsp").forward(req,resp);
            return;
        }
        try {
            SelfHandler.changePassword((String)req.getSession().getAttribute("id"),req.getParameter("old"),req.getParameter("new"),req.getParameter("newn"));
            req.getRequestDispatcher("/true.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalInputExpection illegalInputExpection) {
            String error=illegalInputExpection.getMessage();
            req.setAttribute("error",error);
            req.getRequestDispatcher("/changepassword.jsp").forward(req,resp);
        }
    }
}
