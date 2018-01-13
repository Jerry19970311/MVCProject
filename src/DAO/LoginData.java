package DAO;

import bean.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//登陆信息比对
public class LoginData {
    private Connection connection;
    private String sql="SELECT * FROM t_user WHERE id=? AND password=?";
    private Person person;
    public LoginData(Connection connection){
        this.connection=connection;
    }
    public boolean isTrue(String id,String password) throws SQLException, IllegalInputExpection {
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,password);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            this.person=new Person(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
            return true;
        }else{
            return false;
        }
    }

    public Person getPerson() {
        return person;
    }
}
