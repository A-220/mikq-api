package com.qst.mikq.model;

import com.qst.mikq.enums.Priorities;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// TODO: 09.12.2023 valid, documentation
@Data
@Builder
public class Task {
   private final Long uuid;
   private String name;
   private String description;
   private Priorities priority;
   private final LocalDateTime dateOfCreation;
   private LocalDateTime dateOfDeadLine;
   private Boolean closed;
   private Integer experience;
   private final Long taskOwnerUuid;
}
