package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UniqueUserUpdate {
    private Connection connection;
    private String update="UPDATE t_user SET name=? WHERE id=?";
    private PreparedStatement updateStatement;
    public UniqueUserUpdate(Connection connection,String user) throws SQLException {
        this.connection=connection;
        this.updateStatement=this.connection.prepareStatement(update);
        this.updateStatement.setString(2,user);
    }
    public void submit(String newName) throws SQLException {
        this.updateStatement.setString(1,newName);
        this.updateStatement.execute();
    }
}
