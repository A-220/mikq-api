package com.qst.mikq.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamDto {

    @NonNull
    Long id;

    @NonNull
    String name;
}
