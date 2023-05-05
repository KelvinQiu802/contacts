package org.example.dao;

import org.example.model.Contact;
import org.example.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContactDAO {
    public List<Contact> getAllContacts() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        try (
                Connection conn = DBUtils.connectToDB();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM contacts;");
        ) {
            while (rs.next()) {
                contacts.add(new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("number")));
            }
        }
        return Collections.unmodifiableList(contacts);
    }

    public Contact getContactById(int id) throws SQLException {
        try (
                Connection conn = DBUtils.connectToDB();
                PreparedStatement st = conn.prepareStatement("SELECT * FROM contacts WHERE id = ?;");
        ) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("number"));
                } else {
                    return null;
                }
            }
        }
    }

    public void createContact(String name, String number) throws SQLException {
        try (
                Connection conn = DBUtils.connectToDB();
                PreparedStatement st = conn.prepareStatement("INSERT INTO contacts (name, number) VALUES (?, ?);");
        ) {
            st.setString(1, name);
            st.setString(2, number);
            st.executeUpdate();
        }
    }

    public void deleteContact(int id) throws SQLException {
        try (
                Connection conn = DBUtils.connectToDB();
                PreparedStatement st = conn.prepareStatement("DELETE FROM contacts WHERE id = ?;");
        ) {
            st.setInt(1, id);
            st.executeUpdate();
        }
    }
}
