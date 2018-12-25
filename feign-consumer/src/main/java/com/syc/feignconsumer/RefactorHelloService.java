package com.syc.feignconsumer;

import api.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "HELLO-SERVICE-1")
public interface RefactorHelloService extends HelloService {
}
