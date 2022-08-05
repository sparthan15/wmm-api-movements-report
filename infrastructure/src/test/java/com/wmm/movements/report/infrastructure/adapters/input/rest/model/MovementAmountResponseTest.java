package com.wmm.movements.report.infrastructure.adapters.input.rest.model;

import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MovementAmountResponseTest {

    @Test
    public void test() {
        Tag movementByTag = Tag.builder()
                .tags(List.of("rappi"))
                .amount("10.2")
                .build();
        Assertions.assertNotNull(movementByTag.getAmount());
        Assertions.assertNotNull(movementByTag.getTags());
    }
}