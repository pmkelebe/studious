package com.iliad.comtroller;


import com.iliad.model.Result;
import com.iliad.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/totals")
    public Result getTotals(@RequestParam(value = "numbers") String numbers){
        return resultService.getTotals(numbers);
    }
}
