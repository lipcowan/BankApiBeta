package dev.lipco.services;

import dev.lipco.entities.Client;

import java.util.Set;

public interface ClientService {
    Client createClient(Client client);

    Set<Client> getAllClients();
    Client getClientById(int id);

    Client updateClient(Client client);

    boolean deleteClientById(int id);
}
