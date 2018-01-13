package handler;

import DAO.IllegalInputExpection;
import DAO.QuestionInput;
import DAO.QuestionUpdate;
import DAO.SQLBuilder;
import bean.Question;

import java.sql.SQLException;

//处理问题
public class QuestionManager {
    private static SQLBuilder sqlBuilder;
    //对题目的修改
    private static QuestionUpdate questionUpdate;
    public static Question getUpdateQuestion(int id) throws IllegalInputExpection, SQLException, ClassNotFoundException {
        sqlBuilder=new SQLBuilder();
        questionUpdate=new QuestionUpdate(sqlBuilder.getConnection());
        return questionUpdate.getQuestion(id);
    }
    public static void summit(Question question) throws SQLException {
        questionUpdate.summit(question.getText(),question.getAnswer1(),question.getAnswer2(),question.getAnswer3(),question.getAnswer4(),question.getRightAnswer(),question.getStyle());
        sqlBuilder.close();
    }
    //对题目的增删
    private static QuestionInput questionInput;
    public static void startInput() throws SQLException, ClassNotFoundException {
        sqlBuilder=new SQLBuilder();
        questionInput=new QuestionInput(sqlBuilder.getConnection());
    }
    public static void insert(Question question) throws SQLException {
        questionInput.insertQuestion(question);
    }
    public static void delete(String sign) throws SQLException {
        questionInput.deleteQuestion(sign);
    }
    public static void clear() throws SQLException {
        questionInput.clearQuestion();
    }
    public static void endInput() throws SQLException {
        sqlBuilder.close();
    }
}
