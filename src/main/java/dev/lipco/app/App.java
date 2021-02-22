package dev.lipco.app;

import dev.lipco.controllers.ClientController;
import dev.lipco.daos.ClientDAO;
import dev.lipco.daos.PsqlClientDAO;
import dev.lipco.services.ClientService;
import dev.lipco.services.ClientServiceImpl;

import dev.lipco.controllers.AccountController;
import dev.lipco.daos.AccountDAO;
import dev.lipco.daos.PsqlAccountDAO;
import dev.lipco.services.AccountService;
import dev.lipco.services.AccountServiceImpl;

import io.javalin.Javalin;

// set up the http server and the objects needed to create API
public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        ClientDAO cdao = new PsqlClientDAO();
        AccountDAO adao = new PsqlAccountDAO();
        ClientService cserv = new ClientServiceImpl(cdao);
        AccountService aServ = new AccountServiceImpl(adao);
        // rather than put the lambdas here they will go in the controllers module
        ClientController clientController = new ClientController(cserv);
        AccountController accountController = new AccountController(aServ);

        app.get("/clients", clientController.getAllClients);
        app.post("/clients", clientController.createClient);
        app.get("/clients/:id", clientController.getClientById);
        app.put("/clients/:id", clientController.updateClient);
        app.delete("/clients/:id", clientController.deleteClient);

        app.get("/clients/:cId/accounts", accountController.getAllAccounts);
        app.post("/clients/:cId/accounts", accountController.createAccount);
        app.get("/clients/:cId/accounts/:id", accountController.getAccountsById);
        app.put("/clients/:cId/accounts/:id", accountController.updateAccount);
        app.delete("/clients/:cId/accounts/:id", accountController.deleteAccount);

        app.start();
    }
}
