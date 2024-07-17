package com.digitalchief.zinko.digital_chief_test.web.controller;

import com.digitalchief.zinko.digital_chief_test.service.ErrorService;
import com.digitalchief.zinko.digital_chief_test.service.TaskService;
import com.digitalchief.zinko.digital_chief_test.service.dto.TaskCreateDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.TaskDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ErrorService errorService;

    @PostMapping("/projects/{id}/create")
    public TaskDto create(@PathVariable Long id, @RequestBody @Valid TaskCreateDto taskCreateDto, Errors errors) {
        errorService.checkErrors(errors);
        return taskService.create(id, taskCreateDto);
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @GetMapping("/all")
    public List<TaskDto> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/projects/{id}/all")
    public List<TaskDto> getByProjectId(@PathVariable long id) {
        return taskService.getByProjectId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
