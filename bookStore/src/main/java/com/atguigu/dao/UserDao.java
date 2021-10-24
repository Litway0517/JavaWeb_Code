package com.atguigu.dao;

import com.atguigu.pojo.User;



/**
 * 用户刀
 *
 * @author DELL
 * @date 2021/10/24
 */
public interface UserDao {



    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 如果查询到用户名, 表示存在该用户. 反之亦然.
     */
    public User queryUserByName(String username);


    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 返回null表示用户名或密码错误.
     */
    public User queryByNameAndPassword(String username, String password);


    /**
     * 保存用户信息到数据库
     *
     * @param user 前端传进来的JavaBean对象
     * @return 影响表的记录的数目. 返回-1表示失败.
     */
    public int saveUser(User user);


}
