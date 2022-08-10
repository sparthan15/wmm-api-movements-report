package com.wmm.movements.report.infrastructure.rest;

import com.wmm.movements.report.infrastructure.MovementReportApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        MovementReportApplication.class)
@AutoConfigureMockMvc
public class MovementAmountByUserEndpointTest extends MongoDbTestBase {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String apiUri = "/movements-report";
    private String userIdTest = "1";


    @Test
    void getMovementAmountByUserGroupByTagEndpointTest() throws Exception {
        mockMvc.perform(post(apiUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"initDate\":\"2022-08-05T15:40:12\",\n" +
                                "    \"finalDate\":\"2022-08-09T15:40:12\",\n" +
                                "    \"userId\":\"1\"\n" +
                                "}")
                )
                .andExpect(status().isOk());
    }


}