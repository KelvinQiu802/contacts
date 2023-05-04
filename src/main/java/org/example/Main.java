package org.example;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;


public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(
                        config -> {
                            config.plugins.enableCors(cors -> {
                                cors.add(CorsPluginConfig::anyHost);
                            });
                        }
                )
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);

        app.get("/contacts", (ctx) -> {
            ctx.json(ContactDAO.getAllContacts());
        });

        System.out.println("### The Server is Running ###");
    }
}