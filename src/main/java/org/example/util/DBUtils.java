package org.example.util;

import org.example.dbconfig.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection connectToDB() throws SQLException {
        Connection conn = null;
        String host = DBConfig.host;
        String password = DBConfig.password;
        String userName = DBConfig.userName;
        String dbName = DBConfig.dbname;

        conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" +
                dbName + "?user=" + userName + "&password=" + password);
        System.out.println("### Connection Success ###");

        return conn;
    }
}
