package dev.lipco.controllers;

import com.google.gson.Gson;
import dev.lipco.daos.PsqlAccountDAO;
import dev.lipco.entities.Account;
import dev.lipco.services.AccountService;
import dev.lipco.services.AccountServiceImpl;
import io.javalin.http.Handler;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Set;

public class AccountController {
    private Gson gson = new Gson();
    private AccountService aServ = new AccountServiceImpl(new PsqlAccountDAO());

    public AccountController(AccountService accountService) {this.aServ = accountService;}

    // checking for accounts with specific client, need cId (client_id)
    public Handler getAllAccounts = (ctx) -> {
        int cId = Integer.parseInt(ctx.pathParam("cId"));
        String minVal = ctx.queryParam("minBalance", "NONE");
        String maxVal = ctx.queryParam("maxBalance", "NONE");
        Set<Account> allAccounts = this.aServ.getAccountsByClient(cId);
        Gson gson = new Gson();
        if(allAccounts == null) {
            ctx.result("Currently client " + cId + " doesn't have any accounts with us");
            ctx.status(404);
        }
        if(minVal.equals("NONE") && maxVal.equals("NONE")) {
            String accountsJSON = gson.toJson(allAccounts);
            ctx.result(accountsJSON);
        }else {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            String pattern = "#,##0.0#";
            DecimalFormat df = new DecimalFormat(pattern, symbols);
            df.setParseBigDecimal(true);
            BigDecimal min = (BigDecimal) df.parse(minVal);
            BigDecimal max = (BigDecimal) df.parse(maxVal);
            Set<Account> accounts = this.aServ.getClientAccountsWithinRange(cId, min, max);
            String accountsWithinRange = gson.toJson(accounts);
            ctx.result(accountsWithinRange);
        }
        ctx.status(200);
    };

    public Handler getAccountsById = (ctx) -> {
      int id = Integer.parseInt(ctx.pathParam("id"));
      Account account = this.aServ.getAccountById(id);

      if(account == null) {
          ctx.result("Account not found");
          ctx.status(404);
      }else {
          Gson gson = new Gson();
          String accountJSON = gson.toJson(account);
          ctx.result(accountJSON);
          ctx.status(200);
      }
    };

    // ideally only passing in the balance and the cId is coming from the params
    public Handler createAccount = (ctx) -> {
      String bal = ctx.body();
      int cId = Integer.parseInt(ctx.pathParam("cId"));
      Gson gson = new Gson();
      Account account = gson.fromJson(bal, Account.class);
      account.setcId(cId); // confirms that the cId is taken from params over body
      this.aServ.createAccount(account);
      String json = gson.toJson(account);
      ctx.result(json);
      ctx.status(201);
    };

    public Handler updateAccount = (ctx) -> {
      int id = Integer.parseInt(ctx.pathParam("id"));
      int cId = Integer.parseInt(ctx.pathParam("cId"));
      String body = ctx.body();
      Gson gson = new Gson();
      Account account = gson.fromJson(body, Account.class);
      account.setId(id);
      account.setcId(cId);
      this.aServ.updateAccount(account);
      ctx.status(200);
    };

    public Handler deleteAccount = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = this.aServ.deleteAccountById(id);
        ctx.result(deleted ? "Account was deleted" : "Could not delete account");
        ctx.status(204);
    };

}
