package org.example;

import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);

        app.get("/contacts", (ctx) -> {
            ctx.json(ContactDAO.getAllContacts());
        });

        System.out.println("### The Server is Running ###");
    }
}