package com.qst.mikq.model;

import lombok.Builder;
import lombok.Data;

// TODO: 09.12.2023 valid, documentation
@Data
@Builder
public class PositionAtWork {
    private String title;
    private Integer priority;
}
