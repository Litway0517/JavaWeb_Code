package com.atguigu.test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;


public class UserDaoTest {

    public UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByName() {
        User admin = userDao.queryUserByName("admin");
        System.out.println(admin);
        User admin2 = userDao.queryUserByName("admin2");
        System.out.println(admin2);

        if (admin == null) {
            System.out.println("用户名可用!");
        } else {
            System.out.println("用户名已存在!");
        }

    }

    @Test
    public void queryByNameAndPassword() {
        User user = userDao.queryByNameAndPassword("admin", "admin");
        System.out.println(user);

        if (user == null) {
            System.out.println("用户名或密码错误, 请重新输入!");
        } else {
            System.out.println("登陆成功!");
        }
    }

    @Test
    public void saveUser() {
        /*
            id值是自增的, 所以我们不管他, 直接传入null
            注意 -> 因为刚才User类的id成员类型写成了int, 到这这里填写null出错了. id的类型应该是Integer才正确
         */
        int i = userDao.saveUser(new User(null, "Litway", "Litway123", "Litway@126.com"));
        if (i == -1) {
            System.out.println("操作失败");
        } else {
            System.out.println("操作成功, 共影响" + i + "条数据");
        }

    }
}
