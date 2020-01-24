package com.epam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String manager = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(manager);

        return DriverManager.getConnection(url, user, pass);
    }
}
