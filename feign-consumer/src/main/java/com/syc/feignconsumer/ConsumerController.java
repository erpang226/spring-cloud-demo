package com.syc.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/feign-consumer")
    public String helloConsumer() {

        return helloService.hello();
    }

    @RequestMapping("/feign-consumer2")
    public String helloConsumer2() {
        System.out.println(helloService.hello1("tom"));
        System.out.println(helloService.hello2("tom", 24));
        System.out.println(helloService.hello3(new User("tom", 24)));

        return helloService.hello();
    }
}

