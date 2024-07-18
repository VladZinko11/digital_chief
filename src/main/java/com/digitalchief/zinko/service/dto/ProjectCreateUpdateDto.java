package com.digitalchief.zinko.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectCreateUpdateDto {

    @NotBlank(message = "name must be not empty")
    private String name;
}