package com.digitalchief.zinko.digital_chief_test.service.exception;

public class NotFoundException extends DigitalChiefTestException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
