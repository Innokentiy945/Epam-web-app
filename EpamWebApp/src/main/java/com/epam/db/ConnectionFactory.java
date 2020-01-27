package com.epam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String manager = "org.postgresql.Driver";
    private static final String url = "yourtables&db";
    private static final String user = "yourpassword";
    private static final String pass = "yourpassword";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(manager);

        return DriverManager.getConnection(url, user, pass);
    }
}
