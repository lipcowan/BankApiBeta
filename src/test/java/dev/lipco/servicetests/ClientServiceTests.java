package dev.lipco.servicetests;

import dev.lipco.entities.Client;
import dev.lipco.daos.PsqlClientDAO;
import dev.lipco.services.ClientService;
import dev.lipco.services.ClientServiceImpl;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceTests {

    private static ClientService cserv = new ClientServiceImpl(new PsqlClientDAO());
    private static Client testClient = null;

    @Test
    @Order(1)
    void create_client() {
        Client hp = new Client();
        hp.setFirstName("Harry");
        hp.setLastName("Potter");
        cserv.createClient(hp);
        System.out.println(hp.getFirstName() + " is a new client!");
        Assertions.assertNotEquals(0, hp.getId());
        testClient = hp;
    }

}