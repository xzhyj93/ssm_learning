package cn.controller;

import cn.domain.Account;
import cn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/params")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username) {
        System.out.println("test Params");
        System.out.println("用户名：" +  username);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类当中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user, HttpServletRequest req, HttpServletResponse res) {
        System.out.println(user);
        System.out.println(res);
        System.out.println(req);
        System.out.println(req.getSession());
        System.out.println(req.getSession().getServletContext());
        return "success";
    }

}
