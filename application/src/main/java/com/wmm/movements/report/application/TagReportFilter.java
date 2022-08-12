package com.wmm.movements.report.application;

import com.wmm.movements.domain.vo.MovementType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class TagReportFilter {

    private final String userId;
    private final LocalDateTime initDate;
    private final LocalDateTime finalDate;
    private final String movementType;

    public TagReportFilter() {
        userId = null;
        initDate = null;
        finalDate = null;
        movementType = MovementType.DEBIT.name();
    }
}