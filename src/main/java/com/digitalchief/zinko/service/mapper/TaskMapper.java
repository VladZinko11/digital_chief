package com.digitalchief.zinko.service.mapper;

import com.digitalchief.zinko.data.entity.Task;
import com.digitalchief.zinko.service.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface TaskMapper {

    TaskDto toDto(Task task);

}
