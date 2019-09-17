package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 控制器类
@Controller
@RequestMapping(path="/user")
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello() {
        System.out.println("Hello StringMVC");

        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path="/testRequestMapping", method = {RequestMethod.GET}, params = {"username"})
    public String testRequestMapping(String username) {
        System.out.println("测试RequestMapping注解...." + username);
        return "success";
    }
}
