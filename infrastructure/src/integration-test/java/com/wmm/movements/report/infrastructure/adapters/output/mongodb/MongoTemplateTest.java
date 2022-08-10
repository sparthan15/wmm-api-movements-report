package com.wmm.movements.report.infrastructure.adapters.output.mongodb;

import com.wmm.movements.report.infrastructure.MovementReportApplication;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.MovementByTag;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.Movements;
import com.wmm.movements.report.infrastructure.adapters.output.mongodb.entity.MovementEntity;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

@SpringBootTest(classes = MovementReportApplication.class)
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void getMovementsTest() {
        MatchOperation matchOperation = Aggregation.match(new Criteria("userId").is("1"));
        ProjectionOperation projectionOperation = Aggregation.project("tags", "amount", "userId",
                "description", "date");
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, projectionOperation);
        AggregationResults<MovementEntity> output = mongoTemplate.aggregate(aggregation,
                "movements",
                MovementEntity.class);
        System.out.println(output.getMappedResults());
    }

    @Test
    public void groupTagsAmountByUserId() {
        MatchOperation matchOperation = Aggregation.match(new Criteria("userId").is("1"));
        ProjectionOperation projectionOperation = Aggregation.project("tags", "amount");
        GroupOperation groupOperation = group("tags", "amount").sum("amount").as("amount");

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, projectionOperation,
                groupOperation);
        AggregationResults<Movements> output = mongoTemplate.aggregate(aggregation,
                "movements",
                Movements.class);
        System.out.println(output.getMappedResults());
    }

    @Test
    public void groupTagsMovementdByUserIdWithDateBetween() {
        AggregationResults<Movements> output = getMovementsByDateByUserId();
        Map<String, Set<Double>> tags = output.getMappedResults().stream()
                .map(m -> m.getTags()
                        .stream()
                        .map(t -> MovementByTag.builder().tag(t)
                                .amount(Double.valueOf(m.getAmount()))
                                .build())
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(MovementByTag::getTag, TreeMap::new,
                        Collectors.mapping(MovementByTag::getAmount, Collectors.toSet())));
        System.out.println(tags);
    }


    @Test
    public void groupTagsAmountByUserIdWithDateBetween() {
        AggregationResults<Movements> output = getMovementsByDateByUserId();
        Map<String, List<Double>> tags = output.getMappedResults().stream()
                .map(m -> m.getTags()
                        .stream()
                        .map(t -> MovementByTag.builder().tag(t)
                                .amount(Double.valueOf(m.getAmount()))
                                .build())
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(MovementByTag::getTag,
                        TreeMap::new,
                        Collectors.mapping(MovementByTag::getAmount, Collectors.toList())));
        Map<String, Double> amountByTag = new HashMap<>();
        tags.keySet().stream()
                .forEach(k -> {
                    amountByTag.put(k, tags.get(k).stream()
                            .reduce(Double.valueOf(0), Double::sum));
                });

        System.out.println(amountByTag);
    }

    @NotNull
    private AggregationResults<Movements> getMovementsByDateByUserId() {
        MatchOperation matchOperation = Aggregation.match(new Criteria("userId").is("1").and(
                        "date").gt(LocalDateTime.of(2022, 8, 5, 0, 0, 0))
                .lt(LocalDateTime.of(2022, 8, 5, 23, 59, 59)));
        ProjectionOperation projectionOperation = Aggregation.project("tags", "amount", "date");

        Aggregation aggregation = Aggregation.newAggregation(matchOperation, projectionOperation);
        AggregationResults<Movements> output = mongoTemplate.aggregate(aggregation,
                "movements",
                Movements.class);
        return output;
    }
}