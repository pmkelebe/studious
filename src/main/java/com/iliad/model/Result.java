package com.iliad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Result {
    private Integer result = 0;
    private List<Integer> acceptedInputs = new ArrayList();
    private List<String> allInputs =  new ArrayList();
}
