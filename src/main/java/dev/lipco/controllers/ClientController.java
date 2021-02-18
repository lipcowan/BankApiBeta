package dev.lipco.controllers;

import com.google.gson.Gson;
import dev.lipco.entities.Client;
import dev.lipco.exceptions.InvalidUpdate;
import dev.lipco.services.ClientService;
import io.javalin.http.Handler;

import java.util.Set;

public class ClientController {
    private Gson gson = new Gson();
    private ClientService cserv;

    public ClientController(ClientService clientService) {
        this.cserv = clientService;
    }

    public Handler createClient = (ctx) -> {
      Client client = this.gson.fromJson(ctx.body(), Client.class);
      client = this.cserv.createClient(client);
      String clientJSON = gson.toJson(client);
      ctx.status(201);
      ctx.result(clientJSON);
    };

    public Handler getAllClients = (ctx) -> {
      Set<Client> clients = this.cserv.getAllClients();
      String clientsJSON = this.gson.toJson(clients);
      ctx.status(200);
      ctx.result(clientsJSON);
    };

    public Handler getClientById = (ctx) -> {
      int id = Integer.parseInt(ctx.pathParam("id"));
      Client client = this.cserv.getClientById(id);
      String clientJSON = this.gson.toJson(client);
      ctx.status(200);
      ctx.result(clientJSON);
    };

    public Handler updateClient = (ctx) -> {
      int id = Integer.parseInt(ctx.pathParam("id"));
      Client client = this.gson.fromJson(ctx.body(), Client.class);
      client.setId(id);
      try {
          this.cserv.updateClient(client);
          String clientJSON = this.gson.toJson(client);
          ctx.status(200);
          ctx.result(clientJSON);
      } catch (InvalidUpdate e) {
          ctx.status(400);
          ctx.result("Client cannot be updated");
      }
    };

    public Handler deleteClient = (ctx) -> {
      int id = Integer.parseInt(ctx.pathParam("id"));
      boolean result = this.cserv.deleteClientById(id);
      ctx.status(result? 204 : 404);
    };

}
