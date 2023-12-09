package com.qst.mikq.model;

import com.qst.mikq.enums.Positions;
import javax.validation.constraints.*;

import com.qst.mikq.enums.PrioritiesOfUser;
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
    @NotNull(message = "Role cannot be null")
    @NotEmpty(message = "Role cannot be empty")
    private String role;
    @NotNull(message = "User position cannot be null")
    private PrioritiesOfUser positionAtWork;
    @NotNull(message = "Position cannot be null")
    private Positions position;
    @NotNull(message = "Level cannot be null")
    @Min(value = 0, message = "Level cannot be less than zero")
    @Max(value = 100, message = "Level cannot be more than 100")
    private Integer level;
    @NotNull(message = "Experience cannot be null")
    @Min(value = 0, message = "Experience cannot be less than zero")
    @Max(value = 1000, message = "Experience cannot be more than 1000")
    private Double experience;

    private Long teamUuid;
}
