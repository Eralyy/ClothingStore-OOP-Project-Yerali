package com.yerali.clothingstore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/clothing_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "22067";

    public static Connection getConnection() {
        try {
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected");
            return connection;
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("🔒 Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
