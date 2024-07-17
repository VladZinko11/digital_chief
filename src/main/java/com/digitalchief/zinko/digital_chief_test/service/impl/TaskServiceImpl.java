package com.digitalchief.zinko.digital_chief_test.service.impl;

import com.digitalchief.zinko.digital_chief_test.data.entity.Project;
import com.digitalchief.zinko.digital_chief_test.data.entity.Task;
import com.digitalchief.zinko.digital_chief_test.data.entity.Type;
import com.digitalchief.zinko.digital_chief_test.data.repository.ProjectRepository;
import com.digitalchief.zinko.digital_chief_test.data.repository.TaskRepository;
import com.digitalchief.zinko.digital_chief_test.service.TaskService;
import com.digitalchief.zinko.digital_chief_test.service.dto.TaskCreateDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.TaskDto;
import com.digitalchief.zinko.digital_chief_test.service.exception.NotFoundException;
import com.digitalchief.zinko.digital_chief_test.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    public static final String NOT_FOUND_TASK_WITH_ID = "Not found task with id: ";
    public static final String NOT_FOUND_PROJECT_WITH_ID = "Not found project with id: ";

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto create(Long projectId, TaskCreateDto taskCreateDto) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        Project project = optionalProject.orElseThrow(
                () -> new NotFoundException(NOT_FOUND_PROJECT_WITH_ID + projectId));
        Task task = new Task();
        task.setType(Type.valueOf(taskCreateDto.getType()));
        task.setProject(project);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto getById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.orElseThrow(
                () -> new NotFoundException(NOT_FOUND_TASK_WITH_ID + id));
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().
                map(taskMapper::toDto)
                .toList();
    }

    @Override
    public List<TaskDto> getByProjectId(Long projectId) {
        List<Task> tasks = taskRepository.findByProjectId(projectId);
        return tasks.stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_TASK_WITH_ID + id);
        }
        taskRepository.deleteById(id);
    }
}
