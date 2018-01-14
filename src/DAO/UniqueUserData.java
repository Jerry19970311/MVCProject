package DAO;

import bean.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//用于一般用户进行查看和修改自己个人信息用
public class UniqueUserData {
    private Connection connection;
    private String select="SELECT * FROM t_user WHERE id=?";
    private PreparedStatement selectStatement;
    public UniqueUserData(Connection connection,String user) throws SQLException {
        this.connection=connection;
        this.selectStatement=this.connection.prepareStatement(select);
        this.selectStatement.setString(1,user);
    }
    public Person getSelf() throws SQLException, IllegalInputExpection, NullResultExpection {
        ResultSet resultSet=this.selectStatement.executeQuery();
        if(resultSet.next()){
            return new Person(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }else{
            throw new NullResultExpection("没找到相应的用户");
        }
    }
}
