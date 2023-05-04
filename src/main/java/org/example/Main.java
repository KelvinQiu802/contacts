package org.example;

import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);

        System.out.println("### The Server is Running ###");

        try {
            connectToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connectToDB() throws SQLException {
        Connection conn = null;

        String host = DBConfig.host;
        String password = DBConfig.password;
        String userName = DBConfig.userName;
        String dbName = DBConfig.dbname;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" +
                    dbName + "?user=" + userName + "&password=" + password);
            System.out.println("### Connection Success ###");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("### Connection Lost ###");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}