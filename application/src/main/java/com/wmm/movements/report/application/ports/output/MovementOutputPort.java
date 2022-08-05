package com.wmm.movements.report.application.ports.output;

import com.wmm.movements.report.application.TagReportFilter;

import java.util.Map;

public interface MovementOutputPort {

    Map<String, Double> getMovementsAmountByUserGroupByTag(TagReportFilter tagReportFilter);
}