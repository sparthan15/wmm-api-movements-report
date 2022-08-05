package com.wmm.movements.report.application.ports.input;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.application.ports.output.MovementOutputPort;
import com.wmm.movements.report.application.usecases.GetMovementsAmountByUserGroupByTagUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class GetMovementsAmountByTagInputPort implements GetMovementsAmountByUserGroupByTagUseCase {

    private final MovementOutputPort movementOutputPort;

    @Override
    public Map<String, Double> execute(TagReportFilter tagReportFilter) {
        return movementOutputPort.getMovementsAmountByUserGroupByTag(tagReportFilter);
    }
}