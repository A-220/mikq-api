package com.qst.mikq.model;

import javax.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull(message = "Team cannot be null")
// TODO: 09.12.2023 valid, documentation
public class Team {
    private final Long uuid;
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Size(max = 200, message = "Description cannot be more than 200")
    private String description;
}
