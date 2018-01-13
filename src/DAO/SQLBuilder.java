package DAO;

import java.sql.*;
import java.util.ArrayList;

public class SQLBuilder {
    private Connection connection;
    public SQLBuilder() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://127.0.0.1/xzl?user=root&password=root&useUnicode=true&characterEncoding=8859_1";
        Class.forName("org.gjt.mm.mysql.Driver");
        connection= DriverManager.getConnection(connectionUrl);
        Statement statement=connection.createStatement();
    }
    public Connection getConnection() {
        return connection;
    }
    public void close() throws SQLException {
        this.connection.close();
    }
}
