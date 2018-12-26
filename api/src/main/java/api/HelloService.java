package api;

import dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("refactor")
public interface HelloService {

    @RequestMapping("/")
    String hello();


    /**
     * param 数据绑定测试
     *
     * @param name
     * @return
     */
    @RequestMapping("/hello4")
    String hello4(@RequestParam("name") String name);

    /**
     * header 数据绑定测试
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/hello5")
    User hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    /**
     * body 数据绑定测试
     *
     * @param user
     * @return
     */
    @RequestMapping("/hello6")
    String hello6(@RequestBody User user);
}
