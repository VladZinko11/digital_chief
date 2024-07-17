package com.digitalchief.zinko.digital_chief_test.service;

import com.digitalchief.zinko.digital_chief_test.service.dto.ProjectCreateUpdateDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.ProjectDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.ProjectFullDto;

import java.util.List;

public interface ProjectService {

    ProjectDto create(ProjectCreateUpdateDto projectCreateUpdateDto);

    ProjectFullDto getById(Long id);

    List<ProjectDto> getAll();

    ProjectDto update(Long id, ProjectCreateUpdateDto projectCreateUpdateDto);

    void delete(Long id);
}
