package dev.lipco.daos;

import dev.lipco.entities.Account;

import java.util.*;

public class LocalAccountDAO implements AccountDAO {

    private final Map<Integer, Account> account_table = new HashMap<Integer, Account>();
    private int idCounter = 0;

    @Override
    public Account createAccount(Account account) {
        account.setAccountId(++ this.idCounter);
        account_table.put(this.idCounter, account);
        return account;
    }

    @Override
    public Set<Account> getAllAccounts() {
        Set<Account> accounts = new HashSet<Account>(this.account_table.values());
        return accounts;
    }

    @Override
    public Account getAccountById(int accountId) {
        Account account = this.account_table.get(accountId);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        this.account_table.put(account.getAccountId(), account);
        return account;
    }
    
    @Override
    public boolean deleteAccountById(int accountId) {
        Account account = account_table.remove(accountId);
        return account != null;
    }

}
