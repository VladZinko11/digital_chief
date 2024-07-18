package com.digitalchief.zinko.service.impl;

import com.digitalchief.zinko.data.entity.Project;
import com.digitalchief.zinko.data.repository.ProjectRepository;
import com.digitalchief.zinko.service.ProjectService;
import com.digitalchief.zinko.service.dto.ProjectCreateUpdateDto;
import com.digitalchief.zinko.service.dto.ProjectDto;
import com.digitalchief.zinko.service.dto.ProjectFullDto;
import com.digitalchief.zinko.service.exception.NotFoundException;
import com.digitalchief.zinko.service.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    public static final String NOT_FOUND_PROJECT_WITH_ID = "Not found project with id: ";
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectDto create(ProjectCreateUpdateDto projectCreateUpdateDto) {
        Project project = new Project();
        project.setName(projectCreateUpdateDto.getName());
        projectRepository.save(project);
        return projectMapper.toDto(project);
    }

    @Override
    public ProjectFullDto getById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        Project project = optionalProject.orElseThrow(
                () -> new NotFoundException(NOT_FOUND_PROJECT_WITH_ID + id));
        return projectMapper.toFullDto(project);
    }

    @Override
    public List<ProjectDto> getAll() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::toDto)
                .sorted(Comparator.comparingLong(ProjectDto::getId))
                .toList();
    }

    @Override
    public ProjectDto update(Long id, ProjectCreateUpdateDto projectCreateUpdateDto) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        Project project = optionalProject.orElseThrow(
                () -> new NotFoundException(NOT_FOUND_PROJECT_WITH_ID + id));
        project.setName(projectCreateUpdateDto.getName());
        projectRepository.save(project);
        return projectMapper.toDto(project);
    }

    @Override
    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_PROJECT_WITH_ID + id);
        }
        projectRepository.deleteById(id);
    }
}
