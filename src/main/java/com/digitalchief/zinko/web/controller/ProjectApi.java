package com.digitalchief.zinko.web.controller;

import com.digitalchief.zinko.service.dto.ErrorDto;
import com.digitalchief.zinko.service.dto.ProjectCreateUpdateDto;
import com.digitalchief.zinko.service.dto.ProjectDto;
import com.digitalchief.zinko.service.dto.ProjectFullDto;
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

@Tag(name = "Project", description = "the Project Api")
public interface ProjectApi {

    @Operation(summary = "create new project",
            description = "create new project entity from object, " +
                    "that fetches from request body, " +
                    "and save in db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "create the project",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProjectDto.class))}),
            @ApiResponse(responseCode = "422", description = "invalid field - name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PostMapping("/create")
    ProjectDto create(@RequestBody @Valid ProjectCreateUpdateDto projectCreateUpdateDto, Errors errors);

    @Operation(summary = "get project by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found the project",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProjectFullDto.class))}),
            @ApiResponse(responseCode = "404", description = "project not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @GetMapping("/{id}")
    ProjectFullDto getById(@PathVariable Long id);

    @Operation(summary = "get all projects")
    @ApiResponse(responseCode = "200", description = "found list of project",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProjectDto.class))})
    @GetMapping("/all")
    List<ProjectDto> getAll();

    @Operation(summary = "update project", description = "update project, " +
            "that fetches from data source by id, with object, " +
            "that fetches from request body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updated project",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProjectDto.class))}),
            @ApiResponse(responseCode = "422", description = "invalid field - name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "404", description = "not found project",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @PutMapping("/{id}")
    ProjectDto update(@PathVariable Long id, @RequestBody @Valid ProjectCreateUpdateDto projectCreateUpdateDto, Errors errors);

    @Operation(summary = "delete project by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "deleted project by id",
            content = @Content),
            @ApiResponse(responseCode = "404", description = "not found project",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = ErrorDto.class))})
    })
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
