package com.backend.proyectoclinicaodontologica.controller;

import com.backend.proyectoclinicaodontologica.dto.input.PacienteDtoInput;
import com.backend.proyectoclinicaodontologica.dto.output.PacienteDtoOut;
import com.backend.proyectoclinicaodontologica.testutildata.TestDataUtil;
import com.backend.proyectoclinicaodontologica.utils.JsonPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteControllerTest {
    @Autowired
    private PacienteController pacienteController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteMedianteApi() throws Exception {
        PacienteDtoInput pacienteDtoInput = TestDataUtil.createPacienteDtoInput();
        PacienteDtoOut pacienteDtoOut = TestDataUtil.createPacienteDtoOutConId(1L);

        String requestPayLoad = JsonPrinter.toString(pacienteDtoInput);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectResposeBody = objectMapper.writeValueAsString(objectMapper.readTree(JsonPrinter.toString(pacienteDtoOut)));

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/pacientes/registrar")
                        .content(requestPayLoad)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(expectResposeBody, result.getResponse().getContentAsString());

    }

    @Test
    @Order(2)
    void deberiaEncontarYdvolverPacienteConId1MedianteApi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/pacientes/buscar/{id}", 1L))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dni").value(12345678))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Cass"));
    }


}