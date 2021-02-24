package dev.lipco.services;

import dev.lipco.entities.Account;

import java.math.BigDecimal;
import java.util.Set;

public interface AccountService {
    Account createAccount(Account account);

    Set<Account> getAccountsByClient(int cId);
    Set<Account> getClientAccountsWithinRange(int cId, BigDecimal minBalance, BigDecimal maxBalance);
    Account getAccountById(int id);

    Account updateAccount(Account account);

    boolean deleteAccountById(int id);
}
