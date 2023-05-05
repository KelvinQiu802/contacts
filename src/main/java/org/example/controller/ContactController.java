package org.example.controller;

import io.javalin.http.Context;
import org.example.dao.ContactDAO;

public class ContactController {
    public static void allContacts(Context ctx) {
        ctx.json(ContactDAO.getAllContacts());
    }
}
