package dev.lipco.app;

import io.javalin.Javalin;

// set up the http server and the objects needed to create API
public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // rather than put the lambdas here they will go in the controllers module

        app.start();

    }
}
