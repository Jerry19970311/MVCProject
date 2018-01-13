package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdate {
    private Connection connection;
    private String update="UPDATE t_user SET power=? WHERE id=?";
    private PreparedStatement updateStatement;
    public UserUpdate(Connection connection,String id) throws SQLException {
        this.connection=connection;
        this.updateStatement=this.connection.prepareStatement(update);
        this.updateStatement.setString(2,id);
    }
    public void updatePower(int power) throws IllegalInputExpection, SQLException {
        if(power!=0&&power!=1&&power!=2){
            throw new IllegalInputExpection("请输入正确的权限值！");
        }
        this.updateStatement.setInt(1,power);
    }
}
