# studious
Build a simple REST controller that accepts a comma-separated query parameter as input, and returns a JSON objects in the following form:

 

{
    "result": $totalOfAllIntegerInputs,
    "acceptedInputs": $arrayOfAllAcceptableIntegerInputs,
    "allInputs": $arrayOfAllInputs
}

 

For example, a call to the endpoint 'http://localhost:8080/totals?numbers=1,4,5,NaN,,,,65,32,,,NaN,aString,4,56,99' will produce the following result:

 

{
  "result": 266,
  "acceptedInputs": [
    1,
    4,
    5,
    65,
    32,
    4,
    56,
    99
  ],
  "allInputs": [
    "1",
    "4",
    "5",
    "NaN",
    "",
    "",
    "",
    "65",
    "32",
    "",
    "",
    "NaN",
    "aString",
    "4",
    "56",
    "99"
  ]
}
