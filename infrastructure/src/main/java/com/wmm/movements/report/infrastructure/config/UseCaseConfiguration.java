package com.wmm.movements.report.infrastructure.config;

import com.wmm.movements.report.application.ports.input.GetMovementsAmountByTagInputPort;
import com.wmm.movements.report.application.ports.output.MovementOutputPort;
import com.wmm.movements.report.application.usecases.GetMovementsAmountByUserGroupByTagUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public GetMovementsAmountByUserGroupByTagUseCase getMovementsAmountByUserGroupByTagUseCase(MovementOutputPort movementOutputPort) {
        return new GetMovementsAmountByTagInputPort(movementOutputPort);
    }
}