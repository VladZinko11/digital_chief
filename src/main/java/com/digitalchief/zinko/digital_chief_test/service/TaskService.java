package com.digitalchief.zinko.digital_chief_test.service;

import com.digitalchief.zinko.digital_chief_test.service.dto.TaskCreateDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto create(Long projectId, TaskCreateDto taskCreateDto);

    TaskDto getById(Long id);

    List<TaskDto> getAll();

    List<TaskDto> getByProjectId(Long projectId);

    void delete(Long id);
}
