package dev.lipco.daotests;

import dev.lipco.daos.ClientDAO;
import dev.lipco.daos.PsqlClientDAO;
import dev.lipco.entities.Client;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientDaoTests {
    private static ClientDAO cdao = new PsqlClientDAO();
    static Logger logger = Logger.getLogger(ClientDaoTests.class.getName());

    private static Client testClient = null;

    @Test
    @Order(1)
    void create_client() {
        Client em = new Client(0,"Elon", "Musk");
        cdao.createClient(em);
        System.out.println(em);
        testClient = em;
        Assertions.assertNotEquals(0, em.getId());
    }
}
