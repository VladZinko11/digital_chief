package com.digitalchief.zinko.digital_chief_test.service.mapper;

import com.digitalchief.zinko.digital_chief_test.data.entity.Project;
import com.digitalchief.zinko.digital_chief_test.service.dto.ProjectDto;
import com.digitalchief.zinko.digital_chief_test.service.dto.ProjectFullDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    ProjectDto toDto(Project project);

    ProjectFullDto toFullDto(Project project);

}
