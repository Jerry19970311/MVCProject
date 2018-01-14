package handler;

import DAO.HistoryCount;
import DAO.HistoryData;
import DAO.HistoryManage;
import DAO.SQLBuilder;
import bean.QuestionHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//完成对答题记录的获取。
public class HistorySelect {
    public static List<QuestionHistory> getHistories(String user) throws SQLException, ClassNotFoundException {
        List<QuestionHistory> histories=new ArrayList<QuestionHistory>();
        SQLBuilder sqlBuilder=new SQLBuilder();
        HistoryData historyData=new HistoryData(sqlBuilder.getConnection(),user);
        ResultSet resultSet=historyData.logSelf();
        while (resultSet.next()){
            histories.add(new QuestionHistory(resultSet.getString(1),resultSet.getInt(2),resultSet.getString(4),resultSet.getString(5)));
        }
        return histories;
    }
    public static List<QuestionHistory> getHistories() throws SQLException, ClassNotFoundException {
        List<QuestionHistory> histories=new ArrayList<QuestionHistory>();
        SQLBuilder sqlBuilder=new SQLBuilder();
        HistoryManage historyManage=new HistoryManage(sqlBuilder.getConnection());
        ResultSet resultSet=historyManage.selectLog();
        while (resultSet.next()){
            histories.add(new QuestionHistory(resultSet.getString(1),resultSet.getInt(2),resultSet.getString(4),resultSet.getString(5)));
        }
        return histories;
    }
    public static boolean isAnswered(String user) throws SQLException, ClassNotFoundException {
        SQLBuilder sqlBuilder=new SQLBuilder();
        HistoryCount historyCount=new HistoryCount(sqlBuilder.getConnection(),user);
        if(historyCount.getCount()<=0){
            return false;
        }else{
            return true;
        }
    }
}
