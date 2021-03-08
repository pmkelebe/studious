# studious
Build a simple REST controller that accepts a comma-separated query parameter as input, and returns a JSON objects in the following form:

 

{
    "result": $totalOfAllIntegerInputs,
    "acceptedInputs": $arrayOfAllAcceptableIntegerInputs,
    "allInputs": $arrayOfAllInputs
}

 

For example, a call to the endpoint 'http://localhost:8080/totals?numbers=1,4,5,NaN,,,,65,32,,,NaN,aString,4,56,99' will produce the following result:

 
##### Example Json
 ```
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
```
#### Dependencies 
- spring-boot-starter-web 2.3.1.RELEASE
- spring-boot-starter-test 2.3.1.RELEASE
- jackson-databind 2.10.5.1
- lombok 1.18.12
- junit 4.13.1

#### Project Structure
- src/main/java - All application classes.
  - src/main/java/com/iliad/ - Application class to start the application.
  - src/main/java/com/iliad/service/ - ResultService class and its implementation
  - src/main/java/com/iliad/model/ - Result class.
  - src/main/java/com/iliad/controller/ - ResultController class.
  - src/main/java/com/iliad/config/ - configuration class(es).
  
- src/main/resources - All resources used in main application.

- src/test/java - All test classes
  - src/test/java/com/iliad/service/ - Tests for ResultServiceImpl class.
  - src/test/java/com/iliad/controller/ - Tests for ResultController class. 

 #### Building
 
 Clone locally the project by using this command
 - git clone https://github.com/pmkelebe/studious.git
 
 Build the app locally from the project root folder (/iliad)
 - mvn -U package
 
 #### Running Tests
 
 To run all the test run the following maven goal under /iliad 
 - mvn -U test
 
 #### Running App
 
 To run the app, use the following command
 - java -jar target/iliad-0.0.1-SNAPSHOT.jar
 
 The jar file has all the dependencies. You can copy this from /target folder to any location and then use this command:
 - java -jar iliad-0.0.1-SNAPSHOT.jar
 
 #### Running App in a Docker container
  
 There is a Dockerfile in the project root folder /iliad
 - Build project
   - mvn -U package
 - Build  Docker image by running the command below; use your own chosen image name.
  Note that the dot is required at the end of the command.
   - docker build -t <your_image_name> . 
 - Start your container 
   - docker run  -p 8080:8080 -p 8443:8443 <your_image_name>
 
