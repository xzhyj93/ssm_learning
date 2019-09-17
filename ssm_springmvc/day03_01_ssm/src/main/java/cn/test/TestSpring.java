package cn.test;

import cn.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        IAccountService accountService = (IAccountService)applicationContext.getBean("accountService");
        //调用方法
        accountService.findAll();
    }
}
