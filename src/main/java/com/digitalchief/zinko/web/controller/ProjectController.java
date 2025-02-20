package com.digitalchief.zinko.web.controller;

import com.digitalchief.zinko.service.ErrorService;
import com.digitalchief.zinko.service.ProjectService;
import com.digitalchief.zinko.service.dto.ProjectCreateUpdateDto;
import com.digitalchief.zinko.service.dto.ProjectDto;
import com.digitalchief.zinko.service.dto.ProjectFullDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController implements ProjectApi{
    private final ProjectService projectService;
    private final ErrorService errorService;

    @Override
    @PostMapping("/create")
    public ProjectDto create(@RequestBody @Valid ProjectCreateUpdateDto projectCreateUpdateDto, Errors errors) {
        errorService.checkErrors(errors);
        return projectService.create(projectCreateUpdateDto);
    }

    @Override
    @GetMapping("/{id}")
    public ProjectFullDto getById(@PathVariable Long id) {
        return projectService.getById(id);
    }

    @Override
    @GetMapping("/all")
    public List<ProjectDto> getAll() {
        return projectService.getAll();
    }

    @Override
    @PutMapping("/{id}")
    public ProjectDto update(@PathVariable Long id, @RequestBody @Valid ProjectCreateUpdateDto projectCreateUpdateDto, Errors errors) {
        errorService.checkErrors(errors);
        return projectService.update(id, projectCreateUpdateDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
}
