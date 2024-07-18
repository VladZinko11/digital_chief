package com.digitalchief.zinko.service.exception;

public class DigitalChiefException extends RuntimeException {
    public DigitalChiefException() {
        super();
    }

    public DigitalChiefException(String message) {
        super(message);
    }

    public DigitalChiefException(String message, Throwable cause) {
        super(message, cause);
    }
}
