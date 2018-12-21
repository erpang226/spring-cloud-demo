package com.syc.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service-1")
public interface HelloService {

    @RequestMapping("/")
    String hello();


    /**
     * param 数据绑定测试
     *
     * @param name
     * @return
     */
    @RequestMapping("/hello1")
    String hello1(@RequestParam String name);

    /**
     * header 数据绑定测试
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/hello2")
    User hello2(@RequestHeader String name, @RequestHeader Integer age);

    /**
     * body 数据绑定测试
     * @param user
     * @return
     */
    @RequestMapping("/hello3")
    String hello3(@RequestBody User user);
}
