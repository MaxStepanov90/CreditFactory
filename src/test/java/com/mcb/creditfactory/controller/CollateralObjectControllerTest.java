package com.mcb.creditfactory.controller;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-cars-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-cars-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class CollateralObjectControllerTest {

    @Autowired
    private CollateralObjectController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }
//	"type":"car",
//    "id": 10,
//   "brand": "BMW",
//    "model": "X6",
//    "power": "300",
//    "year": "2020"

    String jsonBody = "{ id: 2, brand: BMW, model: X6, power: 300, year: 2020 }";

    @Test
    void save() throws Exception {
        mockMvc.perform(post("collateral/save")
                .contentType(MediaType.APPLICATION_JSON)
                .param("type", "car")
                .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getInfo() {
    }
}