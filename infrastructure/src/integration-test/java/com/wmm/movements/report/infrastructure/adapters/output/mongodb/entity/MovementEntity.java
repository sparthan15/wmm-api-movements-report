package com.wmm.movements.report.infrastructure.adapters.output.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("movements")
public class MovementEntity {
    @Id
    private String id;
    private double amount;
    private String detail;
    private List<String> tags;
    private String movementType;
    private LocalDateTime date;
    private String userId;
    private LocalDateTime createdAt;


}