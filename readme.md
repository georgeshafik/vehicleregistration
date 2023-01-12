

### Examples executing microservice from command line
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
  or
java -jar vehicleregistration-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

### Setup sample daeta
Installation of MySQL Scripts can be located in SQL folder 

### Basic Endpoint 
REST Endpoint tests are implmented in Postman supported scripts located in the postman folder
These scripts in turn can be used to generate the respective Curl commands.

### Tests 
Unit test coverage is not complete and still in progress
Currently happy path scenarios
Data validation and assumptions to be discussed in demo
Key assumption: based on happy path is all fields in payload json scheama are required.

### SonarQube 
Not implmented

### Coding- checkstyles
Not implmented

### HTTPS and SSO 
Not implmented
