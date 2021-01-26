package cn.msw.ssm.test;

import cn.msw.ssm.dao.AccountDao;
import cn.msw.ssm.domain.Account;
import cn.msw.ssm.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * @Author 毛送文
 * @Date 2021/1/7 0:57
 * @Version 1.0
 */
public class SSMTest {
    @Test
    public void testSpring(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }
    @Test
    public void testMybatis() throws Exception{
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        sqlSession.close();
        is.close();
    }
    @Test
    public void testMybatisSave() throws Exception{
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account=new Account();
        account.setName("ddd");
        account.setMoney(1000.0);
        accountDao.saveAccount(account);
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    /*@Autowired
    private AccountService accountService;
    @Test
    public void testSSM(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }*/
}
