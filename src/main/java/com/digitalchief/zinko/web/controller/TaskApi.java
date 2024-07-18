package com.digitalchief.zinko.web.controller;

import com.digitalchief.zinko.service.dto.ErrorDto;
import com.digitalchief.zinko.service.dto.TaskCreateDto;
import com.digitalchief.zinko.service.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task", description = "the Task api")
public interface TaskApi {

    @Operation(summary = "create new task",
            description = "create new task entity from object, " +
                    "that fetches from request body, " +
                    "id project, that fetches from path variable, " +
                    "and save in db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "create the task",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskDto.class))}),
            @ApiResponse(responseCode = "422", description = "invalid field - type",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PostMapping("/projects/{id}/create")
    TaskDto create(@PathVariable Long id, @RequestBody @Valid TaskCreateDto taskCreateDto, Errors errors);

    @Operation(summary = "get task by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found the task",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskDto.class))}),
            @ApiResponse(responseCode = "404", description = "task not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @GetMapping("/{id}")
    TaskDto getById(@PathVariable Long id);

    @Operation(summary = "get all tasks")
    @ApiResponse(responseCode = "200", description = "found list of tasks",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = TaskDto.class))})
    @GetMapping("/all")
    List<TaskDto> getAll();

    @Operation(summary = "get all tasks by project")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "found list of tasks",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskDto.class))}),
            @ApiResponse(responseCode = "404", description = "not found project",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @GetMapping("/projects/{id}/all")
    List<TaskDto> getByProjectId(@PathVariable long id);

    @Operation(summary = "delete task by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "deleted task by id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "not found task",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
