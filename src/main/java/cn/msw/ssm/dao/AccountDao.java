package cn.msw.ssm.dao;

import cn.msw.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 毛送文
 * @Date 2021/1/7 0:42
 * @Version 1.0
 */
public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);
    void delByid();
    void select();
}
