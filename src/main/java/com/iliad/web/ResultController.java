package com.iliad.web;


import com.iliad.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ResultController {
    @GetMapping("/totals")
    public Result getTotals(@RequestParam(value = "numbers") String numbers){
        Result result = new Result();

        if(null != numbers || !numbers.isEmpty()) {
            String[] nbrs = numbers.split(",");
            result.setResult(nbrs.length);

            //Accepted inputs
            final List<Long> av = new ArrayList<>();
            List<String> acceptedInputs = Arrays.stream(nbrs)
                    .filter(n -> isNumeric(n))
                    .collect(Collectors.toList());
            acceptedInputs.stream().forEach(n -> av.add(Long.valueOf(n)));
            result.setAcceptedInputs(av);

            //All inputs
            List<String> allInputs = Arrays.stream(nbrs)
                    .collect(Collectors.toList());
            result.setAllInputs(allInputs);
        }
        return result;
    }

    private boolean isNumeric(String strNum) {
        final String numRegEx = "[0-9]+";
        if (strNum != null && strNum.matches(numRegEx)) {
            return true;
        }
        return false;
    }
}
