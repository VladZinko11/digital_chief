package com.digitalchief.zinko.digital_chief_test.service.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

public class ValidationException extends DigitalChiefTestException {

    @Getter
    private final Errors errors;

    public ValidationException(Errors errors) {
        this.errors = errors;
    }
}
