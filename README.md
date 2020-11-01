# currency-conversion-service
This project is a test microservice project
It is used to test the call to another microservice called currency-exchange-service
Inside this project, this is a test for the different ways to call microservices

1- RestTemplate. Old way for calling another service.

2- Feign. Which simplify the calling for other services in better structure

For calling more than one instance from the other microservice, I am using Ribbon for load balancing.
Instead of getting the URLs for other microservice from inside the configuration file application.properties, we get it using naming server 

Instead of calling the other microservices direct, this project use zuul api gateway to handle the communication between microservice
This service register  the requests tracing by zipkin and rabbitMQ

# Used inside this project

1-RestTemplate
2-Feign
3- Ribbon
4- Naming server client
5- Zuul api gateway
6- Spring cloud sleuth to add unique ID to logs
7 - Zipkin distributed tracing system using Rabbit MQ [required rabbitMQ and zipkin to be running]

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
to call this microservice using zull api gateway and rest template, this URL is used. 
This URL because zuul use this pattern http://localhost:8765/{application-name}/{uri} and get the URLs for the application from the naming server since it configured with this way in this microservice test project

http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/eur/to/usd/10
to call this microservice using zuul api gateway and the internal communication between microservices used also API gateway, this URL is used using feign request

# Summary
This project is part from some projects created for testing microservice cloud. Those projects are
- spring-cloud-config-server

This service load the configuration for the microservices from repository on github called microservice-config and expose it as web services to be called by other microservices

- eureka naming server

This is a naming server to register the microservices on it to be able to
retrieve the URLs for different microservices by microservice name which defined inside application.properties file

- zuul-api-gateway-server

This is a gateway server to handle the authentication/authorization and the communication between microservices.
This project is created without implementing the business for authentication/authorization for testing.
This service register itself in eureka naming server.
The API gateway know the services URLs which should be called for each request from the eureka naming server.
This service register  the requests tracing by zipkins and rabbitMQ.
 
- limits-service

This service used to test loading configuration from spring-cloud-config-server. It is also used to test the hystrix and resilience circle breaker for fault tolerance
This service register itself in eureka naming server.

- currency-exchange-service

This service used to test the rest template, feign rest client, rubbon client load balancer. It callect the currency exchange rate information from external API
This service register itself in eureka naming server.
This service register  the requests tracing by zipkins and rabbitMQ

- currency-conversion-service

This service used to call the currency-exchange-service to get the currency exchange rate.
This service created to test the rest template, feign rest client, rubbon client load balancer.
This service register itself in eureka naming server.
This service register  the requests tracing by zipkins and rabbitMQ

Starting orders for those services:
- spring-cloud-config-server
- eureka naming server
- zuul-api-gateway-server
- limits-service
- currency-exchange-service
- currency-conversion-service

Tested inside those projects:
- Spring Data JPA
- Spring cloud configuration server read from git repository
- Rest template
- Feign rest client 
- Ribbon client load balancer
- Eureka naming server
- Zuul api gateway
- Spring cloud sleuth to add unique ID to logs
- Zipkin distributed tracing system using Rabbit MQ [required rabbitMQ and zipkin to be running]
- Hystrix and resilience circle breaker for fault tolerance.

