package com.iliad.service;

import com.iliad.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ResultServiceImplTest {

    private ResultServiceImpl resultService;

    @BeforeEach
    public void setUp(){
        resultService = new ResultServiceImpl();
    }

    @Test
    public void getTotalsWithEmptyParam() {
        //Given
        String param = "";

        //When
        Result result = resultService.getTotals(param);

        //Then
        assertThat(result,notNullValue());
        assertThat(result.getResult(),is(0));
        assertThat(result.getAcceptedInputs(),empty());
        assertThat(result.getAllInputs(),empty());


    }

    @Test
    public void getTotals() {
        //Given
        String param = "1,2,,NaN,9";

        //When
        Result result = resultService.getTotals(param);

        //Then
        assertThat(result,notNullValue());
        assertThat(result.getResult(),is(5));
        assertThat(result.getAcceptedInputs(),hasItems(1,2,9));
        assertThat(result.getAllInputs(),hasItems("1","2","","NaN","9"));


    }


}