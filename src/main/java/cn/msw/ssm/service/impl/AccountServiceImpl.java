package cn.msw.ssm.service.impl;

import cn.msw.ssm.dao.AccountDao;
import cn.msw.ssm.domain.Account;
import cn.msw.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 毛送文
 * @Date 2021/1/7 0:44
 * @Version 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户...");
        accountDao.saveAccount(account);
        int a=10/0;
        return;
    }
}
