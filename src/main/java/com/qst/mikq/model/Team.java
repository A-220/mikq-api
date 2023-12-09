package com.qst.mikq.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
// TODO: 09.12.2023 valid, documentation
public class Team {
    private final Long uuid;
    private String name;
    private String description;
}
