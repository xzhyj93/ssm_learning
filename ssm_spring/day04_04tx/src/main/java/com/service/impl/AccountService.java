package com.service.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountService implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

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
        // 2.6. 更新转入账户
        accountDao.updateAccount(target);
    }
}
