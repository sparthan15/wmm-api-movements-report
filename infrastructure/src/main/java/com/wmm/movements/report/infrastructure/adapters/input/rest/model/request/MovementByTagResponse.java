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

    private List<Movements> movements;

    public MovementByTagResponse(Map<String, Double> tagsMap) {
        movements = tagsMap.keySet()
                .stream()
                .map(k -> Movements.builder()
                        .tags(List.of(k))
                        .amount(tagsMap.get(k).toString())
                        .build())
                .collect(Collectors.toList());
    }

}