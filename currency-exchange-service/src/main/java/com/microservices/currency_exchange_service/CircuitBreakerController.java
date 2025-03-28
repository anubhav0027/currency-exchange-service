package com.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api") 
    // @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    // @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String sampleApi(){
       
        // logger.info("Sample api call recieved");
        // ResponseEntity<String> forEntity =  new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        
        // return forEntity.getBody();
        return "sample api";
    }

    public String hardcodedResponse(Exception ex){
        return "hardcoded response";
    }
}

