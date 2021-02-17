package dev.lipco.services;

import dev.lipco.entities.Account;
import java.util.Set;

public interface AccountService {
    Account registerAccount(Account account);

    Set<Account> getAllAccounts();
    Set<Account> getAccountsByCustomerId(int customerId);
    Account getAccountById(int accountId);

    Account updateAccount(Account account);

    boolean deleteAccountById(int accountId);
}
