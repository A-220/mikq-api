package com.qst.mikq.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    @NonNull
    Long id;

    @NonNull
    String name;

    @NonNull
    String login;

    @NonNull
    String password;

    @NonNull
    Integer level;

    @NonNull
    Long experience;
}
