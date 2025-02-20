package com.digitalchief.zinko.service.impl;

import com.digitalchief.zinko.service.ErrorService;
import com.digitalchief.zinko.service.exception.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ErrorServiceImpl implements ErrorService {

    @Override
    public void checkErrors(Errors errors) {
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
    }

    @Override
    public Map<String, List<String>> mapErrors(Errors Errors) {
        return Errors.getFieldErrors()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                FieldError::getField,
                                Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                        )
                );
    }
}
