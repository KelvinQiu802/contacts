package org.example;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import org.example.controller.ContactController;


public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(
                config -> {
                    config.plugins.enableCors(cors -> {
                        cors.add(CorsPluginConfig::anyHost);
                    });
                }
        );

        ContactController contactController = new ContactController();

        app.get("/api/contacts", contactController::allContacts);

        app.get("/api/contacts/{id}", contactController::contactById);

        app.post("/api/contacts/{name}/{number}", contactController::createContact);

        app.delete("/api/contacts/{id}", contactController::deleteContact);

        app.start(7070);
    }
}
