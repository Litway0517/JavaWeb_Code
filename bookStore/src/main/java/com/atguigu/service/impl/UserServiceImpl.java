package com.atguigu.service.impl;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;


/**
 * 用户服务impl
 *
 * @author DELL
 * @date 2021/10/24
 */
public class UserServiceImpl implements UserService {

    /*
        一般处理业务时, 都需要调用数据库, 而 "与数据库相关的操作" 我们全部封装到了DAO层.
        即, 先实例化一个DAO对象. 固然, 处理哪个Bean对象, 就导入哪个Bean对象对应的DAO呗.
     */
    private UserDaoImpl userDao = new UserDaoImpl();


    /**
     * 注册用户
     *
     * @param user JavaBean对象 -> User类型
     */
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }


    /**
     * 用户登录
     *
     * @param user 前端用户登录传递过来的JavaBean对象
     * @return u返回ser对象. 若有值返回则成功. 若null, 则失败.
     */
    @Override
    public User login(User user) {
        return userDao.queryByNameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 校验表中是否已经存在该 <用户名>
     *
     * @param username 用户名
     * @return 若false, 则表中不存在该用户, 可注册.
     * 若true, 则表中存在该用户 -> 不能再使用该用户名注册.
     */
    @Override
    public boolean existsUsername(String username) {
        User user = userDao.queryUserByName(username);
        if (user == null) {
            System.out.println("该用户不存在, 可以注册!");
            return false;
        }
        System.out.println("该用户已存在, 请更换用户名!");
        return true;
    }
}
