package dev.lipco.exceptions;

public class AccountIdNotFoundException extends Exception {
    public  AccountIdNotFoundException(int id) {
        super("Account with ID: " + id + " doesn't exist.");
    }
}
