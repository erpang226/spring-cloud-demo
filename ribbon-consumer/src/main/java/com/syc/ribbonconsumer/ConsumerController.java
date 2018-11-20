package com.syc.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE-1/", String.class).getBody();
    }


}
