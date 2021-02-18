package dev.lipco.servicetests;

import dev.lipco.daos.PsqlClientDAO;
import dev.lipco.entities.Client;
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

    }

    @Test
    @Order(2)
    void update_client() {

    }
}
