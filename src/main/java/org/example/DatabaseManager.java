package org.example;

import java.sql.*;

public class DatabaseManager {

    private static final String url = "jdbc:postgresql://localhost:5432/TZ";
    private static final String username = "postgres";
    private static final String password = "123";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("OK");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
