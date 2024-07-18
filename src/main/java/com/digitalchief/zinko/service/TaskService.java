package com.digitalchief.zinko.service;

import com.digitalchief.zinko.service.dto.TaskCreateDto;
import com.digitalchief.zinko.service.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto create(Long projectId, TaskCreateDto taskCreateDto);

    TaskDto getById(Long id);

    List<TaskDto> getAll();

    List<TaskDto> getByProjectId(Long projectId);

    void delete(Long id);
}
