package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;


/**
 * 用户刀impl
 *
 * @author DELL
 * @date 2021/10/24
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 如果查询到用户名, 表示存在该用户. 反之亦然.
     */
    @Override
    public User queryUserByName(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM t_user WHERE username = ?";
        return queryForOne(User.class, sql, username);
    }


    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 返回null表示用户名或密码错误.
     */
    @Override
    public User queryByNameAndPassword(String username, String password) {
        String sql = "SELECT `id` ID,`username` usr,`password` pwd,`email` FROM t_user WHERE username=?,password=?";
        return queryForOne(User.class, sql, username, password);
    }


    /**
     * 保存用户信息到数据库
     *
     * @param user 前端传进来的JavaBean对象
     * @return 影响表的记录的数目
     */
    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(`username`,`password`,`email`) VALUES(?,?,?)";
        return updateForOne(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
