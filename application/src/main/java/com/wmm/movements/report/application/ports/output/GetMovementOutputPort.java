package com.wmm.movements.report.application.ports.output;

import com.wmm.movements.domain.entity.Movement;
import com.wmm.movements.domain.vo.MovementType;

import java.util.List;

public interface GetMovementOutputPort {

    List<Movement> findByUserId(String userId);

    List<Movement> findByMovementType(String userId, MovementType movementType);

    boolean existsByIdAndUserId(String id, String userId);
}