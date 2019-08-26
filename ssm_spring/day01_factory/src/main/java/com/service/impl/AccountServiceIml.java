package com.service.impl;

import com.dao.IAccountDao;
import com.factory.BeanFactory;
import com.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceIml implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

//    private int i = 1;

    public void  saveAccount(){
        accountDao=(IAccountDao) BeanFactory.getBean("accountDao");
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
