package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ContactDAO {
    public static List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.connectToDB();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM contacts;");
            while (rs.next()) {
                contacts.add(new Contact(rs.getString("Name"), rs.getString("Number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(conn, st, rs);
        }

        return contacts;
    }
}
