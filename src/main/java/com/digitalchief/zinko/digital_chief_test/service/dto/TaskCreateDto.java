package com.digitalchief.zinko.digital_chief_test.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TaskCreateDto {

    public static final String VALIDATE_MESSAGE = "Type must be one of {DESIGN, MARKETING, BUSINESS_DEVELOPMENT, PROJECT_MANAGEMENT}";

    @NotBlank(message = VALIDATE_MESSAGE)
    @Pattern(regexp = "^(DESIGN|MARKETING|BUSINESS_DEVELOPMENT|PROJECT_MANAGEMENT)$", message = VALIDATE_MESSAGE)
    private String type;
}