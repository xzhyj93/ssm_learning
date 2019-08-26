package com.service.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)//只读型事务的配置
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    //需要的是读写型事务配置
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer。。。");
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2. 根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 2.3. 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 2.4. 转入账户加钱
        target.setMoney(target.getMoney() + money);
        // 2.5. 更新转出账户
        accountDao.updateAccount(source);
//        int i = 0 / 0;
        // 2.6. 更新:转入账户
        accountDao.updateAccount(target);
    }
}
