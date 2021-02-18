package dev.lipco.exceptions;

public class InvalidUpdate extends RuntimeException{
    public InvalidUpdate(String message) {
        super(message);
    }
}
