package com.digitalchief.zinko.digital_chief_test.service.mapper;

import com.digitalchief.zinko.digital_chief_test.data.entity.Task;
import com.digitalchief.zinko.digital_chief_test.service.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface TaskMapper {

    TaskDto toDto(Task task);

}
