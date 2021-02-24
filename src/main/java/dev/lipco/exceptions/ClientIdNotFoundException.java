package dev.lipco.exceptions;

public class ClientIdNotFoundException extends Exception{

    public ClientIdNotFoundException(int cId) {
        super("Client with ID: " + cId + " doesn't exist.");
    }
}
