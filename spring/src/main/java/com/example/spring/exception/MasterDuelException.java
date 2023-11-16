package com.example.spring.exception;

public class MasterDuelException extends Exception {

    public MasterDuelException(String message) {
        super(message);
    }

    public MasterDuelException(String string, Exception e) {
        super();
    }
}
