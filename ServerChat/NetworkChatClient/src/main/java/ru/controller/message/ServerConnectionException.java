package ru.controller.message;

public class ServerConnectionException extends Exception{
    public ServerConnectionException(String message, Throwable cause) {

        super(message, cause);
    }
}
