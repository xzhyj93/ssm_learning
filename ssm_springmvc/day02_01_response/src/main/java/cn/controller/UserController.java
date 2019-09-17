package cn.controller;

import cn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString() {
        System.out.println("testString方法执行了");
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向
//        System.out.println(request.getContextPath());
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 直接会进行响应
        response.getWriter().print(" 你好");
        return;

    }

    /**
     * 返回ModelAndView对象
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView方法执行了");

        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        User user =new User();
        user.setUname("美美");
        user.setAge(111);

        // 把user对象储存到mv对象中，也会把user对象存入到request对象中
        mv.addObject("user", user);
        mv.setViewName("success");

        return mv;
   }

    /**
     * 使用关键字的方式进行转发或重定向
     */
    @RequestMapping("testForwardOrRedirect")
   public String testForwardOrRedirect() {
       System.out.println("testForwardOrRedirect方法执行了");

       // 请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/index.jsp";
   }

   @RequestMapping("testAjax")
   public @ResponseBody User testAjax(@RequestBody User user) {
       System.out.println("testAjax执行了");
       // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
       System.out.println(user);
        // 做一个响应。模拟查询数据库

       user.setUname("haha");
       user.setAge(40);

       // 作响应
       return user;
   }
}
