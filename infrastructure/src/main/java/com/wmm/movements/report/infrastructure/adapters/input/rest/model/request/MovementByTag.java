package com.wmm.movements.report.infrastructure.adapters.input.rest.model.request;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovementByTag {

    private String tag;
    private Double amount;

}