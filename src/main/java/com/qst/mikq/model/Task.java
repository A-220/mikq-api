package com.qst.mikq.model;

import com.qst.mikq.enums.PrioritiesOfTask;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// TODO: 09.12.2023 valid, documentation
@Data
@Builder
@NotNull(message = "User cannot be null")
public class Task {
   private final Long uuid;
   @NotNull(message = "Name cannot be null")
   @NotEmpty(message = "Name cannot be empty")
   private String name;
   @Size(max = 200, message = "Description cannot be more than 200")
   private String description;
   @NotNull(message = "Priority cannot be null")
   @NotEmpty(message = "Priority cannot be empty")
   private PrioritiesOfTask priority;
   private final LocalDateTime dateOfCreation;
   private LocalDateTime dateOfDeadLine;
   @NotNull(message = "Closed cannot be null")
   private Boolean closed;
   @NotNull(message = "Experience cannot be null")
   @NotEmpty(message = "Experience cannot be empty")
   private Integer experience;
   @NotNull(message = "TaskOwnerUuid cannot be null")
   @NotEmpty(message = "TaskOwnerUuid cannot be empty")
   private final Long taskOwnerUuid;
}
