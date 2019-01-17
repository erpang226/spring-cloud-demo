package com.syc.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController {


    @Autowired
    private RefactorHelloService refactorHelloService;

    @RequestMapping("/feign-consumer3")
    public String helloConsumer3() {
        System.out.println(refactorHelloService.hello4("tom"));
        System.out.println(refactorHelloService.hello5("tom", 24));
        System.out.println(refactorHelloService.hello6(new dto.User("tom", 24)));

        return refactorHelloService.hello();
    }
}

