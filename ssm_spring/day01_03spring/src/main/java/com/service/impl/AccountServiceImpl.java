package com.service.impl;


import com.dao.IAccountDao;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){

        accountDao.saveAccount();
    }
}
