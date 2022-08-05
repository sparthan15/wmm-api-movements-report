package com.wmm.movements.report.infrastructure.rest;

import org.testcontainers.containers.MongoDBContainer;

public abstract class MongoDbTestBase {

    private static MongoDBContainer database = new MongoDBContainer("mongo:5.0");

    static {
        database.start();
    }

}