package dev.lipco.services;

import dev.lipco.daos.ClientDAO;
import dev.lipco.entities.Client;
import org.apache.log4j.Logger;

import java.util.Set;

public class ClientServiceImpl implements ClientService {

    private static Logger logger = Logger.getLogger(ClientServiceImpl.class.getName());

    private ClientDAO cdao;
    public ClientServiceImpl(ClientDAO clientDAO){
        this.cdao = clientDAO;
    }

    @Override
    public Client createClient(Client client){
        this.cdao.createClient(client);
        return client;
    }

    @Override
    public Set<Client> getAllClients() {
        Set<Client> clients = this.cdao.getAllClients();
        return clients;
    }

    @Override
    public Client getClientById(int id) {
        Client c = this.cdao.getClientById(id);
        return c;
    }

    @Override
    public Client updateClient(Client client) {
        this.cdao.updateClient(client);
        return client;
    }

    @Override
    public boolean deleteClientById(int id) {
        boolean result = this.cdao.deleteClientById(id);
        return result;
    }
}
