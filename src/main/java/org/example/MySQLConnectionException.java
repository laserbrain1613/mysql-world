package org.example;

public class MySQLConnectionException extends Exception {
    private String message;

    public MySQLConnectionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
