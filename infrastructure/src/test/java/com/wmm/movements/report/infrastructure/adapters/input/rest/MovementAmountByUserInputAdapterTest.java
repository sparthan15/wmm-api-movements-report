package com.wmm.movements.report.infrastructure.adapters.input.rest;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.application.usecases.GetMovementsAmountByUserGroupByTagUseCase;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTagResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class MovementAmountByUserInputAdapterTest {

    @Mock
    private GetMovementsAmountByUserGroupByTagUseCase getMovementsAmountByUserGroupByTagUseCase;

    @InjectMocks
    private MovementAmountByUserInputAdapter movementAmountByUserInputAdapter;

    @Test
    public void getMovementByUserIdGroupedByTag() {
        TagReportFilter tagReportFilter = TagReportFilter.builder()
                .userId("123")
                .initDate(LocalDateTime.now())
                .finalDate(LocalDateTime.now())
                .build();
        Mockito.when(getMovementsAmountByUserGroupByTagUseCase.execute(tagReportFilter)).thenReturn(new HashMap());
        MovementByTagResponse movementAmountResponse =
                movementAmountByUserInputAdapter.getMovementByUser(tagReportFilter);
        Assertions.assertThat(movementAmountResponse).isNotNull();
    }
}