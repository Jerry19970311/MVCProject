package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniquePasswordUpdate {
    private Connection connection;
    private String select="SELECT * FROM t_user WHERE id=? AND password=?";
    private PreparedStatement selectStatement;
    private String update="UPDATE t_user SET password=? WHERE id=?";
    private PreparedStatement updateStatement;
    public UniquePasswordUpdate(Connection connection,String user) throws SQLException {
        this.connection=connection;
        this.selectStatement=this.connection.prepareStatement(select);
        this.updateStatement=this.connection.prepareStatement(update);
        this.selectStatement.setString(1,user);
        this.updateStatement.setString(2,user);
    }
    public boolean check(String oldPassword) throws SQLException {
        this.selectStatement.setString(2,oldPassword);
        ResultSet resultSet=this.selectStatement.executeQuery();
        return resultSet.next();
    }
    public void submit(String newPassword) throws SQLException {
        this.updateStatement.setString(1,newPassword);
        this.updateStatement.execute();
    }
}
