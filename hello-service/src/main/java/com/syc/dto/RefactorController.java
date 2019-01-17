package com.syc.dto;

import api.HelloService;
import dto.User;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorController implements HelloService {
    @Override
    public String hello() {

        try {
            int time = RandomUtils.nextInt(3000);
            Thread.sleep(time);
            System.out.println("sleep time :" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "From RefactorController";
    }

    @Override
    public String hello4(String name) {
        return "Hello " + name;
    }

    @Override
    public User hello5(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello6(User user) {
        return "Hello " + user.getName() + " age :" + user.getAge();
    }
}
