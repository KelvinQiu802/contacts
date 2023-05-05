package org.example.dao;

import org.example.model.Contact;
import org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ContactDAO {
    public static List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();

        try (
                Connection conn = DBUtils.connectToDB();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM contacts;");
        ) {
            while (rs.next()) {
                contacts.add(new Contact(rs.getString("Name"), rs.getString("Number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }
}
