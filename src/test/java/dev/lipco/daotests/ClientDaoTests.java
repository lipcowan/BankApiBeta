package dev.lipco.daotests;

import dev.lipco.daos.ClientDAO;
import dev.lipco.daos.PsqlClientDAO;
import dev.lipco.entities.Client;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;


import java.util.Set;
import java.util.HashSet;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientDaoTests {

    private static ClientDAO cdao = new PsqlClientDAO();
    private static Client testClient = null;
    static Logger logger = Logger.getLogger(ClientDaoTests.class.getName());

    @Test
    @Order(1)
    void create_client() {
        Client em = new Client();
        em.setFirstName("Elon");
        em.setLastName("Musk");
        cdao.createClient(em);
        System.out.println(em);
        testClient = em;
        Assertions.assertNotEquals(0, em.getId());
    }

    @Test
    @Order(2)
    void get_all_clients() {
        Set<Client> allClients = cdao.getAllClients();
        Assertions.assertTrue(allClients.size()>1);
    }

    @Test
    @Order(3)
    void get_client_by_id() {
        int id = testClient.getId();
        Client client = cdao.getClientById(id);
        Assertions.assertEquals(testClient.getFirstName(), client.getFirstName());
        System.out.println(client.getFirstName() + " is Client " + client.getId());
    }

    @Test
    @Order(4)
    void update_client() {
        int id = testClient.getId();
        Client client = cdao.getClientById(id);
        client.setFirstName("Not-Elon");
        cdao.updateClient(client);

        Client updatedClient = cdao.getClientById(id);
        Assertions.assertEquals("Not-Elon", updatedClient.getFirstName());
    }

    @Test
    @Order(5)
    void delete_client_by_id() {
        int id = testClient.getId();
        boolean result = cdao.deleteClientById(id);
        Assertions.assertTrue(result);
    }

}
