package com.wmm.movements.report.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Movements {
    private List<String> tags;
    private String amount;
    private LocalDateTime date;

}