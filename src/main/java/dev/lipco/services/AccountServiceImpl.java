package dev.lipco.services;

import dev.lipco.daos.AccountDAO;
import dev.lipco.entities.Account;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class AccountServiceImpl implements AccountService {
    private static Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());
    private AccountDAO adao;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.adao = accountDAO;
    }

    @Override
    public Account activateAccount(Account account) {
        this.adao.createAccount(account);
        return account;
    }

    @Override
    public Set<Account> getAccountsByClient(int cId) {
        Set<Account> allAccounts = this.adao.getAllAccounts();
        Set<Account> clientAccounts = new HashSet<Account>();

        for(Account a : allAccounts) {
            if(a.getcId() == cId) {
                clientAccounts.add(a);
            }
        }
        return clientAccounts;
    }

    @Override
    public Set<Account> getAccountsByBalance(BigDecimal balance) {
        Set<Account> allAccounts = this.adao.getAllAccounts();
        Set<Account> selectedAccounts = new HashSet<Account>();

        for(Account a : allAccounts) {
            if(a.getBalance().equals(balance)) {
                selectedAccounts.add(a);
            }
        }
        return selectedAccounts;
    }

    @Override
    public Account getAccountById(int id) {
        return this.adao.getAccountById(id);
    }

    @Override
    public Account updateAccount(Account account) {
        this.adao.updateAccount(account);
        return account;
    }

    @Override
    public boolean deleteAccountById(int id) {
        return this.adao.deleteAccountById(id);
    }
}
