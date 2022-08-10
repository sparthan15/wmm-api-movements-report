package com.wmm.movements.report.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovementByTagResponse {

    private List<MovementByTag> movements;

    public MovementByTagResponse(Map<String, Double> tagsMap) {
        movements = tagsMap.keySet()
                .stream()
                .map(k -> MovementByTag.builder()
                        .tag(k)
                        .amount(tagsMap.get(k))
                        .build())
                .collect(Collectors.toList());
    }

}