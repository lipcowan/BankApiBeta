package dev.lipco.daos;

import dev.lipco.entities.Account;

import java.util.Set;

public interface AccountDAO {
    Account createAccount(Account account);

    Set<Account> getAllAccounts();
    Account getAccountById(int accountId);

    Account updateAccount(Account account);

    boolean deleteAccountById(int accountID);
}
