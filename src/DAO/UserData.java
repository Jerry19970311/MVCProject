package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//显示所有用户所有的数据
public class UserData {
    private Connection connection;
    private String select="SELECT * FROM t_user";
    private String selectById=select+" ORDER BY id";
    private String selectByName=select+" ORDER BY name";
    private String searchById=select+" WHERE id=?";
    private String searchByName=select+" WHERE name LIKE ?";
    private PreparedStatement selectStatement;
    private PreparedStatement selectByIdStatement;
    private PreparedStatement selectByNameStatement;
    private PreparedStatement searchByIdStatement;
    private PreparedStatement searchByNameStstement;
    public UserData(Connection connection) throws SQLException {
        this.connection=connection;
        this.selectStatement=this.connection.prepareStatement(select);
        this.selectByIdStatement=this.connection.prepareStatement(selectById);
        this.searchByIdStatement=this.connection.prepareStatement(searchById);
        this.selectByNameStatement=this.connection.prepareStatement(selectByName);
        this.searchByNameStstement=this.connection.prepareStatement(searchByName);
    }
    public ResultSet commonSelect() throws SQLException {
        return this.selectStatement.executeQuery();
    }
    public ResultSet idSelect() throws SQLException {
        return this.selectByIdStatement.executeQuery();
    }
    public ResultSet nameSelect() throws SQLException {
        return this.selectByNameStatement.executeQuery();
    }
    public ResultSet idSearch(String id) throws SQLException {
        this.searchByIdStatement.setString(1,id);
        return this.searchByIdStatement.executeQuery();
    }
    public ResultSet nameSearch(String name) throws SQLException {
        this.searchByNameStstement.setString(1,name+"%");
        return this.searchByNameStstement.executeQuery();
    }
}
