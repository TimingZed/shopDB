package com.timing.test;

import com.timing.dao.IUserDao;
import com.timing.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void findAllTest() throws IOException {

        List<User> list= userDao.listUser();
        for (User user : list) {
            System.out.println(user);

        }
    }

    @Test
    public void addUserTest(){
        User user=new User();

        user.setName("德玛西亚之力");
        user.setTrueName("盖伦");
        user.setCardId("431126666666666");
        user.setEmail("1791773433@qq.com");
        user.setQqId("1791773433");
        user.setTelephone("110");
        userDao.saveUser(user);

        System.out.println(user.toString());

    }
}
