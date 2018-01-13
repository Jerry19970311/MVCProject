package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//用于管理员修改和删除所有用户的答题记录用。
public class HistoryManage{
    private Connection connection;
    private String change="UPDATE log_answer SET grade=? WHERE id=?";
    private String delete="DELETE FROM log_answer WHERE id=?";
    private String select="SELECT * FROM log_answer";
    private PreparedStatement changeStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectStatement;
    public HistoryManage(Connection connection) throws SQLException {
        this.connection=connection;
        this.changeStatement=this.connection.prepareStatement(change);
        this.deleteStatement=this.connection.prepareStatement(delete);
        this.selectStatement=this.connection.prepareStatement(select);
    }
    public void changeLog(String id,int grade) throws SQLException {
        this.changeStatement.setInt(1,grade);
        this.changeStatement.setString(2,id);
    }
    //将界面上的信息全部初始化为数据库的信息（可用于初次显示以及撤销所有更改的时候）
    public ResultSet selectLog() throws SQLException {
        return this.selectStatement.executeQuery();
    }
    public void deleteLog(String id) throws SQLException {
        this.deleteStatement.setString(1,id);
    }
}
