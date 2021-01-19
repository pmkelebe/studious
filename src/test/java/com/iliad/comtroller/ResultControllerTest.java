package com.iliad.comtroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iliad.model.Result;
import com.iliad.service.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@WebMvcTest(ResultController.class)
class ResultControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ResultService mockResultService;

    private JacksonTester<Result> jsonResponse;


    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void getTotals() throws Exception {
        Result expectedResult = new Result();
        expectedResult.setResult(5);
        expectedResult.setAcceptedInputs(asList(1,2,9));
        expectedResult.setAllInputs(asList("1","2","","NaN","9"));

        //Given
        given(mockResultService.getTotals("1,2,,NaN,9")).willReturn(expectedResult);

        //When
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/totals")
                .param("numbers","1,2,,NaN,9")
                .contentType(APPLICATION_JSON))
                .andReturn().getResponse();

        //Then
        assertThat(response.getStatus(),is(HttpStatus.
                OK.value()));
        assertThat(response.getContentAsString(),is(
                jsonResponse.write(expectedResult).getJson()));
    }
}