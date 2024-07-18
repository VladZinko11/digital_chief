package com.digitalchief.zinko.service.dto;

import com.digitalchief.zinko.data.entity.Type;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private Type type;
    private ProjectDto project;
}