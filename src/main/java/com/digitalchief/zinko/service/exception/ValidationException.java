package com.digitalchief.zinko.service.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

public class ValidationException extends DigitalChiefException {

    @Getter
    private final Errors errors;

    public ValidationException(Errors errors) {
        this.errors = errors;
    }
}
