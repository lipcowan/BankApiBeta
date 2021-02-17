package dev.lipco.entities;

public class Account {
    // setting up account class with accountID, balance, open boolean for easy searches, and customerID foreign key
    private int accountId;
//    account type - 0 - savings, 1 - checking
//    private int accountType;
    private long activationDate;
    private double accountBalance;
    private boolean isOpen;
    private int customerId;

    // empty constructor
    public Account() {

    }

    public Account(int accountId, long activationDate, double accountBalance, boolean isOpen, int customerId) {
        this.accountId = accountId;
        this.activationDate = activationDate;
        this.accountBalance = accountBalance;
        this.isOpen = isOpen;
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public long getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(long activationDate) {
        this.activationDate = activationDate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // to get account details - overriding the toString method
    @Override
    public String toString() {
        return "Account{" +
                ", accountId= " + accountId +
                ", activationDate= " + activationDate +
                ", accountBalance= " + accountBalance +
                ", isOpen= " + isOpen +
                ", customerId= " + customerId +
                '}';
    }

}
