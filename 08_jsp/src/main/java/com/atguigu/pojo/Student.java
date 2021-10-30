package com.atguigu.pojo;

/**
 * 学生
 *
 * @author DELL
 * @date 2021/10/30
 */
public class Student {

    /**
     * id
     */
    private Integer id;
    /**
     * 的名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 电话
     */
    private String phone;

    /**
     * 学生
     */
    public Student() {
    }

    /**
     * 学生
     *
     * @param id    id
     * @param name  的名字
     * @param age   年龄
     * @param phone 电话
     */
    public Student(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    /**
     * 得到id
     *
     * @return {@code Integer}
     */
    public Integer getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 得到的名字
     *
     * @return {@code String}
     */
    public String getName() {
        return name;
    }

    /**
     * 集名称
     *
     * @param name 的名字
     */
    public void setName(String name) {
        this.name = name;
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
     * 字符串
     *
     * @return {@code String}
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
