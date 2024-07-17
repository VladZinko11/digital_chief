package com.digitalchief.zinko.digital_chief_test.service.dto;

import com.digitalchief.zinko.digital_chief_test.data.entity.Type;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private Type type;
    private ProjectDto project;
}