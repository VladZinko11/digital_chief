package com.digitalchief.zinko.digital_chief_test.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectFullDto {
    private Long id;
    private String name;
    private List<TaskDto> tasks;
}