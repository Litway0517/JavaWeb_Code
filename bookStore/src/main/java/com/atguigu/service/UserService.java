package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {


    /**
     * 注册用户
     * @param user JavaBean对象 -> User类型
     */
    public void registerUser(String user);


    /**
     * 用户登录
     * @param user 前端用户登录传递过来的JavaBean对象
     * @return user对象
     */
    public User login(User user);


    /**
     * 校验表中是否已经存在该 <用户名>
     * @param username 用户名
     * @return 若false, 则表中不存在该用户, 可注册.
     *         若true, 则表中存在该用户 -> 不能再使用该用户名注册.
     */
    public boolean existsUsername(String username);

}
