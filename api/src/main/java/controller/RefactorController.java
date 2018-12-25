package controller;

import api.HelloService;
import dto.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorController implements HelloService {
    @Override
    public String hello() {
        return "say hello!";
    }

    @Override
    public String hello4(String name) {
        return "hello " + name;
    }

    @Override
    public User hello5(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello6(User user) {
        return "hello " + user.getName() + "," + user.getAge();
    }
}
