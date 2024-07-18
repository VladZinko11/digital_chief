package com.digitalchief.zinko.service.mapper;

import com.digitalchief.zinko.data.entity.Project;
import com.digitalchief.zinko.service.dto.ProjectDto;
import com.digitalchief.zinko.service.dto.ProjectFullDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    ProjectDto toDto(Project project);

    ProjectFullDto toFullDto(Project project);

}
