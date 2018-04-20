package kr.ac.jejunu;


import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JejuConnectionMaker implements ConnectionMaker {

    @Value("${db.classname}")
    private String className;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        className = "com.mysql.jdbc.Driver";
        Class.forName(className);
        url = "jdbc:mysql://localhost/jeju?characterEncoding=utf8";
        username = "jeju";
        password = "jejupw";
        return DriverManager.getConnection(url, username, password);
    }
}
