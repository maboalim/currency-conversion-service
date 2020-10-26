# currency-conversion-service
This project is a test microservice project
It is used to test the call to another microservice called currency-exchange-service
Inside this project, this is a test for the different ways to call microservices

1- RestTemplate. Old way for calling another service.

2- Feign. Which simplify the calling for other services in better structure

For calling more than one instance from the other microservice, I am using Ribbon for load balancing.
Instead of getting the URLs for other microservice from inside the configuration file application.properties, we get it using naming server 

Instead of calling the other microservices direct, this project use zuul api gateway to handle the communication between microservice

# Used inside this project

1-RestTemplate
2-Feign
3- Ribbon
4- Naming server client
5- Zuul api gateway

# Port
This service use port 8100 as defined in application.properties file

# Environment information
Java 8
IDE Eclipse
maven 3.6.3

#URLs
http://localhost:8100/currency-conversion/from/eur/to/usd/10
to call this microservice direct, this URL is used using rest template

http://localhost:8100/currency-conversion-feign/from/eur/to/usd/10
to call this microservice direct, this URL is used feign and modified to used the API gateway instead of direct all to the second microservice

http://localhost:8765/currency-conversion-service/currency-conversion/from/eur/to/usd/10
to call this microservice using zull api gateway and rest template, this URL is used 

http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/eur/to/usd/10
to call this microservice using zull api gateway and the internal communication between microservices used also API gateway, this URL is used using feign request
