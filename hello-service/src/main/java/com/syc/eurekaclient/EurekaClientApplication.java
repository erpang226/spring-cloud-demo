package com.syc.eurekaclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String home(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
