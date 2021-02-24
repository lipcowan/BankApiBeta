package dev.lipco.exceptions;

public class InvalidUpdateException extends RuntimeException{
    public InvalidUpdateException(String message) {
        super(message);
    }
}
