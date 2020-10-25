# currency-conversion-service
This project is a test microservice project
It is used to test the call to another microservice called currency-exchange-service
Inside this project, this is a test for the different ways to call microservices

1- RestTemplate. Old way for calling another service.

2- Feign. Which simplify the calling for other services in better structure

For calling more than one instance from the other microservice, I am using Ribbon for load balancing.
Instead of getting the URLs for other microservice from inside the configuration file application.properties, we get it using naming server 

# Used inside this project

1-RestTemplate
2-Feign
3- Ribbon
4- naming server client

# Port
This service use port 8100 as defined in application.properties file

# Environment information
Java 8
IDE Eclipse
maven 3.6.3