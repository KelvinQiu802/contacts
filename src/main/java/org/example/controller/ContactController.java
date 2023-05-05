package org.example.controller;

import io.javalin.http.Context;
import org.example.dao.ContactDAO;

import java.sql.SQLException;

public class ContactController {
    private ContactDAO contactDAO = null;

    public ContactController() {
        this.contactDAO = new ContactDAO();
    }

    public void allContacts(Context ctx) {
        try {
            ctx.json(contactDAO.getAllContacts());
        } catch (SQLException e) {
            ctx.result("Internal Server Error").status(500);
        }
    }

    public void contactById(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(contactDAO.getContactById(id));
        } catch (NumberFormatException e) {
            ctx.result("Invalid ID").status(400);
        } catch (SQLException e) {
            ctx.result("Internal Server Error").status(500);
        }
    }
}
