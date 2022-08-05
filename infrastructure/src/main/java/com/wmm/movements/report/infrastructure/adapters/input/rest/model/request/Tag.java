package com.wmm.movements.report.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Tag {
    private List<String> tags;
    private String amount;

}