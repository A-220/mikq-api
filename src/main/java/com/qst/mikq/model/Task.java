package com.qst.mikq.model;

import com.qst.mikq.annotations.DateOfDeadLine;
import com.qst.mikq.enums.PrioritiesOfTask;

import javax.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// TODO: 09.12.2023 valid, documentation
@Data
@Builder
@NotNull(message = "Task cannot be null")
public class Task {
   private final Long id;
   private final Long taskOwnerUuid;
   private final LocalDateTime dateOfCreation;

   @NotNull(message = "Name cannot be null")
   @NotEmpty(message = "Name cannot be empty")
   @Size(min = 8, max = 50, message = "Name of team cannot be less than zero or more than 50 characters")
   private String name;

   @Size(max = 200, message = "Description cannot be more than 200")
   private String description;

   @NotNull(message = "Priority cannot be null")
   private PrioritiesOfTask priority;

   @DateOfDeadLine
   private LocalDateTime dateOfDeadLine;

   @NotNull(message = "Closed cannot be null")
   private Boolean closed;

   @NotNull(message = "Experience cannot be null")
   @NotEmpty(message = "Experience cannot be empty")
   private Integer experience;
}
