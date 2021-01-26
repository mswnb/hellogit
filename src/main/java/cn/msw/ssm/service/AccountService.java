package cn.msw.ssm.service;

import cn.msw.ssm.domain.Account;

import java.util.List;

/**
 * @Author 毛送文
 * @Date 2021/1/7 0:44
 * @Version 1.0
 */
public interface AccountService {
    List<Account> findAll();
    void saveAccount(Account account);
}
