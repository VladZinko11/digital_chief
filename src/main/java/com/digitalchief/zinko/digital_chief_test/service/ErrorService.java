package com.digitalchief.zinko.digital_chief_test.service;

import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

public interface ErrorService {
    void checkErrors(Errors errors);

    Map<String, List<String>> mapErrors(Errors Errors);
}
