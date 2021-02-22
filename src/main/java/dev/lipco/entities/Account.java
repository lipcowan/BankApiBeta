package dev.lipco.entities;

import java.math.BigDecimal;

public class Account {
    private int id;
    private BigDecimal balance;
    private int cId;

    // empty constructor
    public Account() {
    }

    public Account(int accountId, BigDecimal accountBalance, int customerId) {
        this.id = accountId;
        this.balance = accountBalance;
        this.id = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    // to get account details - overriding the toString method
    @Override
    public String toString() {
        return "Account{" +
                ", accountId= " + id +
                ", accountBalance= " + balance +
                ", customerId= " + cId +
                '}';
    }

}
