package com.service.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import com.utils.ThransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl_OLD implements IAccountService {
    private IAccountDao accountDao;
    private ThransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(ThransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            List<Account> accounts = accountDao.findAllAccount();

            //3. 提交事务
            txManager.commit();
            //4. 返回结果
            return accounts;

        }catch (Exception e) {
            //5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6. 释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            Account account = accountDao.findAccountById(accountId);
            //3. 提交事务
            txManager.commit();
            //4. 返回结果
            return account;
        }catch (Exception e) {
            //5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            accountDao.saveAccount(account);
            //3. 提交事务
            txManager.commit();
            //4. 返回结果
        }catch (Exception e) {
            //5. 回滚操作
            txManager.rollback();
        } finally {
            //6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            accountDao.updateAccount(account);
            //3. 提交事务
            txManager.commit();
            //4. 返回结果
        }catch (Exception e) {
            //5. 回滚操作
            txManager.rollback();
        } finally {
            //6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try {
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            accountDao.deleteAccount(acccountId);
            //3. 提交事务
            txManager.commit();
            //4. 返回结果
        }catch (Exception e) {
            //5. 回滚操作
            txManager.rollback();
        } finally {
            //6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1. 开启事务
            txManager.beginTransaction();
            //2. 执行操作
            // 2.1. 根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            // 2.2. 根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 2.3. 转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 2.4. 转入账户加钱
            target.setMoney(target.getMoney() + money);
            // 2.5. 更新转出账户
            accountDao.updateAccount(source);
            int i = 0/0;
            // 2.6. 更新转入账户
            accountDao.updateAccount(target);
            //3. 提交事务
            txManager.commit();
            //4. 返回结果
        }catch (Exception e) {
            //5. 回滚操作
            txManager.rollback();
            e.printStackTrace();
        } finally {
            //6. 释放连接
            txManager.release();
        }


    }
}
