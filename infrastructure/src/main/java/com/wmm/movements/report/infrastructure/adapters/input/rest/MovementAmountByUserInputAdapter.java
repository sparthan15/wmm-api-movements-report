package com.wmm.movements.report.infrastructure.adapters.input.rest;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.application.usecases.GetMovementsAmountByUserGroupByTagUseCase;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("movement-report")
public class MovementAmountByUserInputAdapter {

    private final GetMovementsAmountByUserGroupByTagUseCase getMovementsAmountByUserGroupByTagUseCase;

    @PostMapping
    public MovementByTagResponse getMovementByUser(@RequestBody TagReportFilter tagReportFilter) {
        Map<String, Double> map =
                getMovementsAmountByUserGroupByTagUseCase.execute(tagReportFilter);
        return new MovementByTagResponse(map);

    }
}