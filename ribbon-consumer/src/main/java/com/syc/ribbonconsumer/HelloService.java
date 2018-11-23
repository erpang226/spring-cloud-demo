package com.syc.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE-1/", String.class).getBody();
    }

    public String helloFallBack() {
        return "error";
    }

}
