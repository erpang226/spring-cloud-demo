package com.syc.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-service-1")
public interface HelloService {

    @RequestMapping("/")
    String hello();
}
