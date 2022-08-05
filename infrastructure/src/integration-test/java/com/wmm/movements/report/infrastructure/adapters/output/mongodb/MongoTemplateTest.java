package com.wmm.movements.report.infrastructure.adapters.output.mongodb;

import com.wmm.movements.report.infrastructure.MovementReportApplication;
import com.wmm.movements.report.infrastructure.adapters.input.rest.model.request.Tag;
import com.wmm.movements.report.infrastructure.adapters.output.mongodb.entity.MovementEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

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
        AggregationResults<Tag> output = mongoTemplate.aggregate(aggregation,
                "movements",
                Tag.class);
        System.out.println(output.getMappedResults());
    }
}