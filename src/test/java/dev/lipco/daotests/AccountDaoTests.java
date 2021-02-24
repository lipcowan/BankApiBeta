package dev.lipco.daotests;

import dev.lipco.daos.AccountDAO;
import dev.lipco.daos.PsqlAccountDAO;
import dev.lipco.entities.Account;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;


import java.math.BigDecimal;
import java.util.Set;
import java.util.HashSet;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTests {
    private static AccountDAO adao = new PsqlAccountDAO();
    private static Account testAccount = null;
    static Logger logger = Logger.getLogger(AccountDaoTests.class.getName());

    @Test
    @Order(1)
    void create_account() {
        Account elonAccount = new Account();
        BigDecimal accountBalance = new BigDecimal("1500.00");
        elonAccount.setBalance(accountBalance);
        elonAccount.setcId(10);
        adao.createAccount(elonAccount);
        System.out.println(elonAccount);
        testAccount = elonAccount;
        Assertions.assertNotEquals(0, elonAccount.getId());
    }

    @Test
    @Order(2)
    void get_all_accounts() {
        Set<Account> allAccounts = adao.getAllAccounts();
        Assertions.assertTrue(allAccounts.size()>=1);
    }

    @Test
    @Order(3)
    void get_account_by_id() {
        int id = testAccount.getId();
        Account account = adao.getAccountById(id);
        Assertions.assertEquals(testAccount.getBalance(), account.getBalance());
        System.out.println("Testing on account " + testAccount.getId());
    }

    @Test
    @Order(4)
    void update_account() {
        int id = testAccount.getId();
        Account account = adao.getAccountById(id);
        BigDecimal updatedBalance = new BigDecimal("35000.00");
        account.setBalance(updatedBalance);
        adao.updateAccount(account);
        Account updatedAccount = adao.getAccountById(id);
        Assertions.assertEquals(account.getBalance(), updatedAccount.getBalance());
        System.out.println("New balance is " + updatedAccount.getBalance());
    }

    @Test
    @Order(5)
    void delete_account_by_id() {
        int id = testAccount.getId();
        boolean result = adao.deleteAccountById(id);
        Assertions.assertTrue(result);
        System.out.println("Deleted account " + id);
    }
}
