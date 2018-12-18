package com.syc.eurekaclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String home() throws InterruptedException {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        int time = new Random().nextInt(3000);

        System.out.println("sleep: " + time + "ms");
        Thread.sleep(time);
        return "hello world";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return "hello " + name;
    }

    @RequestMapping("/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestBody User user) {
        return "hello " + user.getName() + "," + user.getAge();
    }





    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
