package org.example.controller;

import io.javalin.http.Context;
import org.example.dao.ContactDAO;

public class ContactController {
    private ContactDAO contactDAO = null;

    public ContactController() {
        this.contactDAO = new ContactDAO();
    }

    public void allContacts(Context ctx) {
        ctx.json(contactDAO.getAllContacts());
    }
}
