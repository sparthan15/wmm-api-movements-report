package com.wmm.movements.report.infrastructure.adapters.input.rest.model;

import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTag;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTagResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovementByTagResponseTest {

    @Test
    public void test() {
        MovementByTagResponse movementByTagResponse = MovementByTagResponse.builder()
                .movements(List.of(MovementByTag.builder()
                        .tag("rappi")
                        .amount(10.2)
                        .build()))
                .build();
        Assertions.assertNotNull(movementByTagResponse.getMovements());
    }

    @Test
    public void validateMapConstructurTest() {
        Map<String, Double> tagsMap = new HashMap<>();
        MovementByTagResponse movementByTagResponse = new MovementByTagResponse(tagsMap);
    }
}