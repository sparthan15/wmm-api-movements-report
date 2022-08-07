package com.wmm.movements.report.infrastructure.adapters.input.rest.model.response;

import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovementByTagTest {

    @Test
    public void test() {
        MovementByTag movementByTag = MovementByTag.builder().tag("rappi").amount("100").build();
        Assertions.assertThat(movementByTag.getTag()).isNotNull();
        Assertions.assertThat(movementByTag.getAmount()).isNotNull();
    }
}