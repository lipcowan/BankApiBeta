package dev.lipco.daos;

import dev.lipco.entities.Account;
import java.util.Set;

public interface AccountDAO {
    //CREATE
    Account createAccount(Account account);

    //READ
    Set<Account> getAllAccounts();
    Account getAccountById(int id);

    //UPDATE
    Account updateAccount(Account account);

    //DELETE
    boolean deleteAccountById(int id);
}
