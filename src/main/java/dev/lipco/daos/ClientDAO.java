package dev.lipco.daos;

import dev.lipco.entities.Client;

import java.util.Set;

// where we place our crud operators
public interface ClientDAO {
    // CREATE
    Client createClient(Client client);

    // READ
    Set<Client> getAllClients();
    Client getClientById(int id);

    // UPDATE
    Client updateClient(Client client);

    // DELETE
    boolean deleteClientById(int id);
}
