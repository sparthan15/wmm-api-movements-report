package com.wmm.movements.report.application.usecases.input;

import com.wmm.movements.domain.vo.MovementType;
import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.application.ports.input.GetMovementsAmountByTagInputPort;
import com.wmm.movements.report.application.ports.output.MovementOutputPort;
import com.wmm.movements.report.application.usecases.input.util.ObjectFactoryTestUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class GetMovementAmountByTagUseCaseTest {

    @InjectMocks
    private GetMovementsAmountByTagInputPort getMovementsAmountByTagInputPort;

    @Mock
    private MovementOutputPort movementOutputPort;

    private TagReportFilter tagReportFilter = TagReportFilter.builder()
            .userId("23423J")
            .initDate(ObjectFactoryTestUtilities.createLocalDateTime())
            .finalDate(ObjectFactoryTestUtilities.createLocalDateTime())
            .build();

    @Test
    public void getMovementAmountByTagTest() {
        Mockito.when(movementOutputPort.getMovementsAmountByUserGroupByTag(tagReportFilter)).thenReturn(Map.of(
                "rappi", 200.0));
        Map<String, Double> tagsByUser = getMovementsAmountByTagInputPort.execute(tagReportFilter);
        assertNotNull(tagsByUser);
        assertEquals(tagReportFilter.getMovementType(), MovementType.DEBIT.name());
    }
}