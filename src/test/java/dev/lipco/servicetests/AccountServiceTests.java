package dev.lipco.servicetests;

// since we have some unique methods in the service and controller we should be testing them here
import dev.lipco.entities.Account;
import dev.lipco.daos.PsqlAccountDAO;
import dev.lipco.services.AccountService;
import dev.lipco.services.AccountServiceImpl;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class AccountServiceTests {

    private static AccountService aserv = new AccountServiceImpl(new PsqlAccountDAO());

    @Test
    void get_accounts_by_client() {
        int cId = 1;
        Set<Account> clientAccounts = aserv.getAccountsByClient(cId);
        System.out.println(clientAccounts);
        Assertions.assertNotNull(clientAccounts);
    }

    @Test
    void get_accounts_within_range() {
        int cId = 1;
        BigDecimal minVal = new BigDecimal("100.00");
        BigDecimal maxVal = new BigDecimal("3000.00");
        Set<Account> selectedAccounts = aserv.getClientAccountsWithinRange(cId, minVal, maxVal);
        System.out.println(selectedAccounts);
        Assertions.assertNotNull(selectedAccounts);
    }



}
