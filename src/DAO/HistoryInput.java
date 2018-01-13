package DAO;

import bean.QuestionHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//答题记录修改：用于用户在答题以后提交答题记录使用。
public class HistoryInput{
    private String input1="INSERT INTO log_answer(id,grade,time,user_id) VALUES (?,?,?,?)";
    private String input2="INSERT INTO log_answer VALUES (?,?,?,?,?)";
    private String updateTest="UPDATE log_answer SET grade_text=? WHERE id=?";
    private String count="SELECT count(*) FROM log_answer WHERE user_id=?";
    private Connection connection;
    private PreparedStatement preparedStatement1;
    private PreparedStatement preparedStatement2;
    private PreparedStatement updateTestStatement;
    private PreparedStatement countStatement;
    public HistoryInput(Connection connection) throws SQLException {
        this.connection=connection;
        this.countStatement=this.connection.prepareStatement(count);
    }
    public void summit(String id,int grade,String time,String user) throws SQLException {
        this.preparedStatement1=this.connection.prepareStatement(input1);
        this.preparedStatement1.setString(1,id);
        this.preparedStatement1.setInt(2,grade);
        this.preparedStatement1.setString(3,time);
        this.preparedStatement1.setString(4,user);
        this.preparedStatement1.execute();
    }
    public void summit(QuestionHistory questionHistory) throws SQLException {
        this.preparedStatement2=this.connection.prepareStatement(input2);
        this.preparedStatement2.setString(1,questionHistory.getId());
        this.preparedStatement2.setInt(2,questionHistory.getGrade());
        this.preparedStatement2.setInt(3,questionHistory.getGrade());
        this.preparedStatement2.setString(4,questionHistory.getTime());
        this.preparedStatement2.setString(5,questionHistory.getUser());
        this.preparedStatement2.execute();
    }
    public void updateText(int id,int grade) throws SQLException {
        this.updateTestStatement=this.connection.prepareStatement(updateTest);
        this.updateTestStatement.setInt(1,grade);
        this.updateTestStatement.setInt(2,id);
        this.updateTestStatement.execute();
    }
    public int getCount(String user) throws SQLException {
        this.countStatement.setString(1,user);
        ResultSet number=this.countStatement.executeQuery();
        number.next();
        return number.getInt(1);
    }
}
