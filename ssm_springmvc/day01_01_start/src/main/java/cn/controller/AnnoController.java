package cn.controller;

import cn.domain.User;
import cn.utils.String2DateConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */

@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam() {
        System.out.println("test requestparam");
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了。。");
        System.out.println(body);
        return "success";
    }


    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value="id") String id) {
        System.out.println("执行了。。");
        System.out.println(id);
        return "success";
    }


    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute 执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法会先执行
     */
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser 执行了");
//        // 通过用户查询数据库（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser 执行了");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    @RequestMapping(value="testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了");
        model.addAttribute("msg", "m欸吗");
        return "success";
    }
}
