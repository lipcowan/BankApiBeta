package dev.lipco.app;

import dev.lipco.controllers.ClientController;
import dev.lipco.daos.ClientDAO;
import dev.lipco.daos.PsqlClientDAO;
import dev.lipco.services.ClientService;
import dev.lipco.services.ClientServiceImpl;
import io.javalin.Javalin;

// set up the http server and the objects needed to create API
public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        ClientDAO cdao = new PsqlClientDAO();
        ClientService cserv = new ClientServiceImpl(cdao);
        // rather than put the lambdas here they will go in the controllers module
        ClientController clientController = new ClientController(cserv);

        app.get("/clients", clientController.getAllClients);
        app.post("/clients", clientController.createClient);
        app.get("/clients/:id", clientController.getClientById);
        app.put("/clients/:id", clientController.updateClient);
        app.delete("/clients/:id", clientController.deleteClient);

        app.start();
    }
}
