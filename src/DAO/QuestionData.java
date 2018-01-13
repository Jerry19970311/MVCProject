package DAO;

import bean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//获取问题
public class QuestionData {
    protected Connection connection;
    private String select="SELECT * FROM question";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public QuestionData(Connection connection) throws SQLException {
        this.connection=connection;
        this.preparedStatement=connection.prepareStatement(select);
    }

    public List<Question> getQuestions() throws SQLException {
        resultSet=preparedStatement.executeQuery();
        ArrayList<Question> q=new ArrayList<Question>();
        while (resultSet.next()){
            q.add(new Question(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9)));
            System.out.println(resultSet.getInt(9));
        }
        //Question[] questions=q.toArray(new Question[q.size()]);
        return q;
    }
}
