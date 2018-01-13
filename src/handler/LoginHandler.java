package handler;

import DAO.IllegalInputExpection;
import DAO.LoginData;
import DAO.SQLBuilder;
import bean.Person;

import java.sql.SQLException;

public class LoginHandler{
    private static SQLBuilder sqlBuilder;
    private static LoginData loginData;
    public static Person getPerson(String id, String password) throws SQLException, ClassNotFoundException, LoginErrorExpection, IllegalInputExpection {
        sqlBuilder=new SQLBuilder();
        loginData=new LoginData(sqlBuilder.getConnection());
        if(loginData.isTrue(id,password)){
            sqlBuilder.close();
            return loginData.getPerson();
        }else{
            sqlBuilder.close();
            throw new LoginErrorExpection("账号或者密码错误");
        }
    }
}
