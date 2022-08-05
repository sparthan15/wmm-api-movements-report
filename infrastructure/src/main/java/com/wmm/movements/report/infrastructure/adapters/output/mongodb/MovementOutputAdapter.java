package com.wmm.movements.report.infrastructure.adapters.output.mongodb;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.application.ports.output.MovementOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovementOutputAdapter implements MovementOutputPort {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, Double> getMovementsAmountByUserGroupByTag(TagReportFilter tagReportFilter) {

        return new HashMap<>();
    }
}