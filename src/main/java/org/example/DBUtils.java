package org.example;

import java.sql.*;

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

    public static void closeAll(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
