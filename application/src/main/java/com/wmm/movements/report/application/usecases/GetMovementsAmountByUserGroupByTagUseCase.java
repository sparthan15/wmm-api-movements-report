package com.wmm.movements.report.application.usecases;

import com.wmm.movements.report.application.TagReportFilter;

import java.util.Map;

public interface GetMovementsAmountByUserGroupByTagUseCase {

    Map<String, Double> execute(TagReportFilter tagReportFilter);
}