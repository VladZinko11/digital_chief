package com.digitalchief.zinko.digital_chief_test.web.controller;

import com.digitalchief.zinko.digital_chief_test.service.ErrorService;
import com.digitalchief.zinko.digital_chief_test.service.dto.ErrorDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.ValidationResultDto;
import com.digitalchief.zinko.digital_chief_test.service.exception.NotFoundException;
import com.digitalchief.zinko.digital_chief_test.service.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestController
@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorController {
    private final ErrorService errorService;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto error(Exception e) {
        return new ErrorDto("Server error", "Oops, something wrong with server");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto error(NotFoundException e) {
        return new ErrorDto(HttpStatus.NOT_FOUND.toString(), e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorDto error(ValidationException e) {
        Map<String, List<String>> errors = errorService.mapErrors(e.getErrors());
        return new ValidationResultDto(errors);
    }

}
