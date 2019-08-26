package com.service.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import com.utils.ThransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
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
