package com.iliad.service;

import com.iliad.model.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {
    @Override
    public Result getTotals(String commaSeparatedNumbers) {
        Result result = new Result();

        if(null != commaSeparatedNumbers && !commaSeparatedNumbers.isEmpty()) {
            String[] nbrs = commaSeparatedNumbers.split(",");
            result.setResult(nbrs.length);

            //Accepted inputs
            final List<Integer> av = new ArrayList<>();
            List<String> acceptedInputs = Arrays.stream(nbrs)
                    .filter(n -> isNumeric(n))
                    .collect(Collectors.toList());
            acceptedInputs.stream().forEach(n -> av.add(Integer.valueOf(n)));
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
