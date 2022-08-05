package com.wmm.movements.report.infrastructure.adapters.input.rest.model;

import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTagResponse;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovementByTagResponseTest {

    @Test
    public void test() {
        MovementByTagResponse movementByTagResponse = MovementByTagResponse.builder()
                .tags(List.of(Tag.builder()
                        .tags(List.of("rappi"))
                        .amount("10.2")
                        .build()))
                .build();
        Assertions.assertNotNull(movementByTagResponse.getTags());
    }

    @Test
    public void validateMapConstructurTest() {
        Map<String, Double> tagsMap = new HashMap<>();
        MovementByTagResponse movementByTagResponse = new MovementByTagResponse(tagsMap);
    }
}