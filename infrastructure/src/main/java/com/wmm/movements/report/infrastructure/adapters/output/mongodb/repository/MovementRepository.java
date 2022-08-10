package com.wmm.movements.report.infrastructure.adapters.output.mongodb.repository;

import com.wmm.movements.report.application.TagReportFilter;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTag;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.Movements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Repository
public class MovementRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public TreeMap<String, List<Double>> getMovementsByTagByDateByUserId(TagReportFilter tagReportFilter) {
        MatchOperation matchOperation =
                Aggregation.match(new Criteria("userId").is(tagReportFilter.getUserId()).and(
                                "date").gt(tagReportFilter.getInitDate())
                        .lt(tagReportFilter.getFinalDate()));
        ProjectionOperation projectionOperation = Aggregation.project("tags", "amount", "date");

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, projectionOperation);
        AggregationResults<Movements> output = mongoTemplate.aggregate(aggregation,
                "movements",
                Movements.class);

        return output.getMappedResults().stream()
                .map(t -> MovementByTag.builder().tag(t.getTags().get(0))
                        .amount(Double.valueOf(t.getAmount()))
                        .build())
                .collect(Collectors.groupingBy(MovementByTag::getTag, TreeMap::new,
                        Collectors.mapping(MovementByTag::getAmount, Collectors.toList())));
    }

    public Map<String, Double> getMovementsAmountByTagByDateByUserId(TagReportFilter tagReportFilter) {
        Map<String, List<Double>> movementsByTag = getMovementsByTagByDateByUserId(tagReportFilter);
        Map<String, Double> amountByTag = new HashMap<>();

        movementsByTag.keySet().stream()
                .forEach(k -> {
                    amountByTag.put(k, movementsByTag.get(k).stream()
                            .reduce(Double.valueOf(0), Double::sum));
                });
        return amountByTag;
    }


}