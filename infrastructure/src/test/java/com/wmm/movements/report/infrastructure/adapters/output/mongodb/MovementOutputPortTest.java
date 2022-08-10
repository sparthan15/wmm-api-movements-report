package com.wmm.movements.report.infrastructure.adapters.output.mongodb;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.infrastructure.adapters.output.mongodb.repository.MovementRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovementOutputPortTest {

    @InjectMocks
    private MovementOutputAdapter movementOutputAdapter;

    @Mock
    private MovementRepository movementRepository;

    @Test
    public void test1() {
        TagReportFilter tagReportFilter = TagReportFilter.builder()
                .userId("1")
                .initDate(LocalDateTime.now())
                .finalDate(LocalDateTime.now())
                .build();
        TreeMap<String, Double> movementsByTag = new TreeMap<>();
        movementsByTag.put("rappi", Double.valueOf(2000.5));
        when(movementRepository.getMovementsAmountByTagByDateByUserId(tagReportFilter)).thenReturn(movementsByTag);
        Map<String, Double> mapsTagAmount = movementOutputAdapter.
                getMovementsAmountByUserGroupByTag(tagReportFilter);
        System.out.println(mapsTagAmount);
        Assertions.assertThat(mapsTagAmount).isNotNull();
    }

    @Test
    public void sumAllAmounts() {

    }
}