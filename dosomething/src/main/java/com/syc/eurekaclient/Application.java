package com.syc.eurekaclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String home() throws InterruptedException {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        int time = new Random().nextInt(3000);

        System.out.println("sleep: " + time + "ms");
        Thread.sleep(time);


        return "hello world";
    }
}
