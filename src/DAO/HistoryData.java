package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//用于用户查看自己的答题记录用，不可查看他人。
public class HistoryData{
    private Connection connection;
    private String log="SELECT * FROM log_answer WHERE user_id=?";
    private PreparedStatement logStatement;
    public HistoryData(Connection connection,String id) throws SQLException {
        this.connection=connection;
        this.logStatement=this.connection.prepareStatement(log);
        this.logStatement.setString(1,id);
    }
    public ResultSet logSelf() throws SQLException {
        return this.logStatement.executeQuery();
    }
}
