package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryCount{
    private Connection connection;
    private String count="SELECT count(*) FROM log_answer WHERE user_id=?";
    private PreparedStatement preparedStatement;
    public HistoryCount(Connection connection,String user) throws SQLException {
        this.connection=connection;
        this.preparedStatement=this.connection.prepareStatement(count);
        this.preparedStatement.setString(1,user);
    }
    public int getCount() throws SQLException {
        ResultSet resultSet=this.preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
