package handler;

import DAO.*;
import bean.Person;
import com.sun.istack.NotNull;

import java.sql.SQLException;

public class SelfHandler {
    public static Person getSelf(String user) throws SQLException, ClassNotFoundException, IllegalInputExpection, NullResultExpection {
        SQLBuilder sqlBuilder=new SQLBuilder();
        Person person=new UniqueUserData(sqlBuilder.getConnection(),user).getSelf();
        sqlBuilder.close();
        return person;
    }
    public static void changeName(String id,String name) throws SQLException, ClassNotFoundException {
        SQLBuilder sqlBuilder=new SQLBuilder();
        new UniqueUserUpdate(sqlBuilder.getConnection(),id).submit(name);
    }
    public static void changePassword(String user,@NotNull String old,@NotNull String np1,@NotNull String np2) throws SQLException, ClassNotFoundException, IllegalInputExpection {
        SQLBuilder sqlBuilder=new SQLBuilder();
        UniquePasswordUpdate uniquePasswordUpdate=new UniquePasswordUpdate(sqlBuilder.getConnection(),user);
        if(uniquePasswordUpdate.check(old)==false){
            throw new IllegalInputExpection("原来的密码输入错误！");
        }
        if(np1.equals(np2)==false){
            throw new IllegalInputExpection("新的密码确认失败！");
        }
        if((np1.length()>20)||(np1.length()<=0)){
            throw new IllegalInputExpection("新密码长度须在1至20个字符之间");
        }
        uniquePasswordUpdate.submit(np1);
        sqlBuilder.close();
    }
}
