package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;



/**
 * 用户服务测试
 *
 * @author DELL
 * @date 2021/10/24
 */
public class UserServiceTest {

    public UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Test
    public void registerUser() {
        userServiceImpl.registerUser(new User(null, "Litway1", "Litway123", "litway@gmail.com"));
        userServiceImpl.registerUser(new User(null, "Litway2", "Litway123", "litway@gmail.com"));
    }

    @Test
    public void login() {
        User user = userServiceImpl.login(new User(null, "Litway", "Litway123", null));
        System.out.println(user);
    }

    @Test
    public void existsUsername() {
        userServiceImpl.existsUsername("Litway");
        userServiceImpl.existsUsername("Litway123");
    }
}
