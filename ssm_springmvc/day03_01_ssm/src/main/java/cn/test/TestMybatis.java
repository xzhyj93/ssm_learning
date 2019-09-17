package cn.test;

import cn.dao.IAccountDao;
import cn.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //创建SqlSession对象
        SqlSession session = factory.openSession();

        // 获取到代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //查询所有数据
        List<Account> list = dao.findAll();
        for(Account account : list) {
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws IOException
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setMoney(400d);
        account.setName("胸大");
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //创建SqlSession对象
        SqlSession session = factory.openSession();

        // 获取到代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);

        dao.saveAccount(account);
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
