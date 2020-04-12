package com.greeting.exceptions;

public class GreetingException extends RuntimeException {
    String exceptionMessage;

    public enum ExceptionTypes {
        NO_RECORD_FOUND
    }

    public ExceptionTypes exceptionTypes;

    public GreetingException(String message, ExceptionTypes types) {
        super(message);
        this.exceptionMessage = message;
        this.exceptionTypes = types;
    }
}
