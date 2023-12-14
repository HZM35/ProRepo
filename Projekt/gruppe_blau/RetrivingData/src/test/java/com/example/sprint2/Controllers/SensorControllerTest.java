package com.example.sprint2.Controllers;

import com.example.sprint2.Repositories.SensorDataRepository;
import com.example.sprint2.Repositories.SensorReposistory;
import com.example.sprint2.Services.SensorDataService;
import com.example.sprint2.Services.SensorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@WebMvcTest(SensorController.class)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-H2Test.properties")
class SensorControllerTest {

//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;

    @MockBean
    SensorService service;
    @MockBean
    SensorReposistory sensorReposistory;
    @MockBean
    SensorDataService sensorDataServiceservice;
    @MockBean
    SensorDataRepository sensorDataRepository;




    @Test
    void getAllIdTest() throws Exception {


        List<String> list = new ArrayList<>(Arrays.asList("iuwueiwei", "8728327328"));

        when(service.getAllId()).thenReturn(list);


        RequestBuilder request  = get("/allSensors");
        MvcResult result = mvc.perform(request).andReturn();

        mvc.perform(get("/allSensors")).
                andDo(print()).
                andExpect(status().isOk());





        

        

    }






}