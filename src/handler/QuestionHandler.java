package handler;

import DAO.HistoryCount;
import DAO.HistoryInput;
import DAO.QuestionData;
import DAO.SQLBuilder;
import bean.Question;

import java.sql.SQLException;
import java.util.*;

//处理答题
public class QuestionHandler{
    public static List<Question> questions;
    public static Hashtable<Integer,String> singleAnswer=new Hashtable<Integer, String>();
    public static Hashtable<Integer,String[]> complexAnswer=new Hashtable<Integer, String[]>();
    public static void getquestions() throws SQLException, ClassNotFoundException {
        SQLBuilder sqlBuilder=new SQLBuilder();
        questions=new QuestionData(sqlBuilder.getConnection()).getQuestions();
        for(int i=0;i<questions.size();i++){
            System.out.println("类型:"+questions.get(i).getStyle());
        }
        sqlBuilder.close();
    }
    public static int score(){
        return singleScore()+complexScore();
    }
    private static int singleScore(){
        int score=0;
        Enumeration<Integer> e1=singleAnswer.keys();
        while (e1.hasMoreElements()){
            int index=e1.nextElement();
            String singleRight=questions.get(index).getRightAnswer();
            if(singleRight.equals(singleAnswer.get(index))){
                score++;
            }
        }
        return score;
    }
    private static int complexScore(){
        int score=0;
        Enumeration<Integer> e2=complexAnswer.keys();
        while (e2.hasMoreElements()){
            int index=e2.nextElement();
            String complexRight=questions.get(index).getRightAnswer();
            String[] answers=complexAnswer.get(index);
            for(int i=0;i<answers.length;i++){
                if(complexRight.indexOf(answers[i])>=0){
                    score++;
                }
            }
        }
        return score;
    }
    public static void summitGrade(int grade,String user_id) throws SQLException, ClassNotFoundException {
        SQLBuilder sqlBuilder=new SQLBuilder();
        HistoryInput historyInput=new HistoryInput(sqlBuilder.getConnection());
        int count=historyInput.getCount(user_id);
        historyInput.summit(user_id+"_"+String.valueOf(count+1),grade,new Date().toString(),user_id);
        sqlBuilder.close();
    }
}
