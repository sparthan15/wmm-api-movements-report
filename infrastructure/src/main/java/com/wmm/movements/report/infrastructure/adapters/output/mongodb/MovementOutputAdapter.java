package com.wmm.movements.report.infrastructure.adapters.output.mongodb;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.application.ports.output.MovementOutputPort;
import com.wmm.movements.report.infrastructure.adapters.output.mongodb.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovementOutputAdapter implements MovementOutputPort {


    private final MovementRepository movementRepository;

    @Override
    public Map<String, Double> getMovementsAmountByUserGroupByTag(TagReportFilter tagReportFilter) {
        return
                movementRepository.getMovementsAmountByTagByDateByUserId(tagReportFilter);

    }


}