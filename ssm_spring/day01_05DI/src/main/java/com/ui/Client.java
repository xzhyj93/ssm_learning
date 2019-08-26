package com.ui;

import com.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService service = (IAccountService)context.getBean("accountService3");

        service.saveAccount();
    }
}
