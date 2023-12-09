package com.qst.mikq.model;

import com.qst.mikq.enums.Positions;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NotNull(message = "User cannot be null")
// TODO: 09.12.2023 validation and context, documentation
public class User {
    private final Long uuid;
    @NotNull(message = "Login cannot be null")
    @NotEmpty(message = "Login cannot be empty")
    @Size(min = 8, max = 50, message = "Login cannot be less than zero or more than 50 characters")
    private String login;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, max = 50, message = "Password cannot be less than zero or more than 50 characters")
    private String password;
    @Size(max = 200, message = "Description cannot be more than 200")
    private String description;
    private String role;
    private PositionAtWork positionAtWork;
    private Positions position;
    private Integer level;
    private Double experience;
    private Long teamUuid;
}
