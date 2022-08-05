package com.wmm.movements.report.application.usecases.input.util;

import java.time.LocalDateTime;

public class ObjectFactoryTestUtilities {

    public static LocalDateTime createLocalDateTime() {
        return LocalDateTime.of(2022, 01, 20, 00, 00, 22);
    }
}