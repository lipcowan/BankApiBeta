package dev.lipco.services;

import dev.lipco.daos.AccountDAO;
import dev.lipco.entities.Account;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AccountServiceImpl {
    static Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());

    private AccountDAO adao;
    public AccountServiceImpl(AccountDAO accountDAO){
        this.adao = accountDAO;
    }


}
