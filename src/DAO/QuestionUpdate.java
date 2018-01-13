package DAO;

import bean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//更改问题（序号和唯一标识符不能更改）
public class QuestionUpdate {
    private Connection connection;
    private int index;
    private String updateBefore="SELECT * FROM question WHERE id=?";
    private String updatetext="UPDATE question SET text=?,ans1=?,ans2=?,ans3=?,ans4=?,right_ans=?,style=?";
    private PreparedStatement updateBeforeStatement;
    private PreparedStatement updateTextStatement;
    public QuestionUpdate(Connection connection) throws SQLException {
        this.connection=connection;
        this.updateBeforeStatement=this.connection.prepareStatement(updateBefore);
        this.updateTextStatement=this.connection.prepareStatement(updatetext);
    }
    public Question getQuestion(int id) throws SQLException, IllegalInputExpection {
        this.updateBeforeStatement.setInt(1,id);
        ResultSet resultSet=this.updateBeforeStatement.executeQuery();
        if(resultSet.next()){
            Question result=new Question(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9));
            return result;
        }else{
            throw new IllegalInputExpection();
        }
    }
    public void summit(String text,String ans1,String ans2,String ans3,String ans4,String rightAns,int style) throws SQLException {
        this.updateTextStatement.setString(1,text);
        this.updateTextStatement.setString(2,ans1);
        this.updateTextStatement.setString(3,ans2);
        this.updateTextStatement.setString(4,ans3);
        this.updateTextStatement.setString(5,ans4);
        this.updateTextStatement.setString(6,rightAns);
        this.updateTextStatement.setInt(7,style);
        this.updateTextStatement.execute();
    }
}
