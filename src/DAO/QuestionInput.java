package DAO;

import bean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//对题目库的增加、修改、删除、清空
//QuestionData类中的操作，任何用户都会调用到，而QuestionInput中的操作，只有管理员才能涉及，因此该类继承QuestionData。
public class QuestionInput extends QuestionData{
    private String insert="INSERT INTO question VALUES (?,?,?,?,?,?,?,?,?)";
    private PreparedStatement insertStatement;
    private String delete="DELETE FROM question WHERE sign=?";
    private PreparedStatement deleteStatement;
    private String clear="DELETE FROM question";
    private PreparedStatement clearStatement;
    public QuestionInput(Connection connection) throws SQLException {
        super(connection);
        this.insertStatement=this.connection.prepareStatement(insert);
        this.deleteStatement=this.connection.prepareStatement(delete);
        this.clearStatement=this.connection.prepareStatement(clear);
    }
    public void insertQuestion(Question question) throws SQLException {
        this.insertStatement.setInt(1,question.getIndex());
        this.insertStatement.setString(2,question.getText());
        this.insertStatement.setString(3,question.getAnswer1());
        this.insertStatement.setString(4,question.getAnswer2());
        this.insertStatement.setString(5,question.getAnswer3());
        this.insertStatement.setString(6,question.getAnswer4());
        this.insertStatement.setString(7,question.getRightAnswer());
        this.insertStatement.setString(8,question.getSign());
        this.insertStatement.setInt(9,question.getStyle());
        this.insertStatement.execute();
    }
    public void insertQuestion(int id,String text,String ans1,String ans2,String ans3,String ans4,String rightAns,String sign,int style) throws SQLException {
        insertQuestion(new Question(id,text,ans1,ans2,ans3,ans4,rightAns,sign,style));
    }
    public void deleteQuestion(String sign) throws SQLException {
        this.deleteStatement.setString(1,sign);
        this.deleteStatement.execute();
    }
    public void clearQuestion() throws SQLException {
        this.clearStatement.execute();
    }
}
