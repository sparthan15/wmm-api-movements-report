package com.wmm.movements.report.infrastructure.adapters.output.mongodb;

import com.wmm.movements.report.application.TagReportFilter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MovementOutputPortTest {

    @InjectMocks
    private MovementOutputAdapter movementOutputAdapter;

    @Mock
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        TagReportFilter tagReportFilter = TagReportFilter.builder()
                .userId("123aa")
                .initDate(LocalDateTime.now())
                .finalDate(LocalDateTime.now())
                .build();
        Map<String, Double> mapsTagAmount = movementOutputAdapter.
                getMovementsAmountByUserGroupByTag(tagReportFilter);
        Assertions.assertThat(mapsTagAmount).isNotNull();
    }
}