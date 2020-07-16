package com.iliad.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iliad.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ResultController.class)
class ResultControllerTest {

    @Autowired
    private MockMvc mvc;

    // controller under test
    private ResultController resultController;

    private JacksonTester<Result> jsonResponse;


    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void getTotals() throws Exception {
        Result expectedResult = new Result();
        expectedResult.setResult(5);
        expectedResult.setAcceptedInputs(asList(1L,2L,9L));
        expectedResult.setAllInputs(asList("1","2","","NaN","9"));

        //When
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/totals")
                .param("numbers","1,2,,NaN,9")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        //Then
        assertThat(response.getStatus(),is(HttpStatus.
                OK.value()));
        assertThat(response.getContentAsString(),is(
                jsonResponse.write(expectedResult).getJson()));
    }
}