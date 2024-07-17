package com.digitalchief.zinko.digital_chief_test.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectCreateUpdateDto {

    @NotBlank(message = "name must be not empty")
    private String name;
}