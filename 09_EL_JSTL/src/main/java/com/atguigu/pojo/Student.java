package com.atguigu.pojo;

/**
 * 学生
 *
 * @author DELL
 * @date 2021/11/06
 */
public class Student {

    /**
     * 斯图id
     */
    private Integer stuId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话
     */
    private String phone;

    /**
     * 好吧
     */
    private boolean ok;


    /**
     * 学生
     */
    public Student() {
    }

    /**
     * 学生
     *
     * @param stuId    斯图id
     * @param username 用户名
     * @param password 密码
     * @param age      年龄
     * @param phone    电话
     */
    public Student(Integer stuId, String username, String password, Integer age, String phone) {
        this.stuId = stuId;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
    }

    /**
     * 学生
     *
     * @param stuId    斯图id
     * @param username 用户名
     * @param password 密码
     * @param age      年龄
     * @param phone    电话
     * @param ok       好吧
     */
    public Student(Integer stuId, String username, String password, Integer age, String phone, boolean ok) {
        this.stuId = stuId;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.ok = ok;
    }

    /**
     * 得到stu id
     * 得到stu id
     *
     * @return {@code Integer}
     */
    public Integer getStuId() {
        return stuId;
    }

    /**
     * 斯图设置id
     *
     * @param stuId 斯图id
     */
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    /**
     * 获得用户名
     *
     * @return {@code String}
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 得到密码
     *
     * @return {@code String}
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 让年龄
     *
     * @return {@code Integer}
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设定年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 得到电话
     *
     * @return {@code String}
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 是可以的
     *
     * @return boolean
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * 设置好了
     *
     * @param ok 好吧
     */
    public void setOk(boolean ok) {
        this.ok = ok;
    }
}

