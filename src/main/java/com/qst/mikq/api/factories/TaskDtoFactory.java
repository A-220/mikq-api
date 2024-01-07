package com.qst.mikq.api.factories;

import com.qst.mikq.api.dto.TaskDto;
import com.qst.mikq.storage.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoFactory {

    public TaskDto makeTaskDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .description(taskEntity.getDescription())
                .createdAt(taskEntity.getCreatedAt())
                .deadline(taskEntity.getDeadline())
                .experience(taskEntity.getExperience())
                .build()
    }

}
