package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 人
 *
 * @author DELL
 * @date 2021/11/01
 */
public class Person {

    /**
     * 的名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 手机
     */
    private String[] phones;
    /**
     * 城市
     */
    private List<String> cities;
    /**
     * 地图
     */
    private Map<Object, String> map;

    /**
     * 人
     */
    public Person() {
    }

    /**
     * 人
     *
     * @param name   的名字
     * @param age    年龄
     * @param phones 手机
     * @param cities 城市
     * @param map    地图
     */
    public Person(String name, Integer age, String[] phones, List<String> cities, Map<Object, String> map) {
        this.name = name;
        this.age = age;
        this.phones = phones;
        this.cities = cities;
        this.map = map;
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
     * 得到手机
     *
     * @return {@code String[]}
     */
    public String[] getPhones() {
        return phones;
    }

    /**
     * 设置手机
     *
     * @param phones 手机
     */
    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    /**
     * 得到城市
     *
     * @return {@code List<String>}
     */
    public List<String> getCities() {
        return cities;
    }

    /**
     * 设置城市
     *
     * @param cities 城市
     */
    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    /**
     * 得到地图
     *
     * @return {@code Map<Object, String>}
     */
    public Map<Object, String> getMap() {
        return map;
    }

    /**
     * 设置地图
     *
     * @param map 地图
     */
    public void setMap(Map<Object, String> map) {
        this.map = map;
    }

    /**
     * 字符串
     *
     * @return {@code String}
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phones=" + Arrays.toString(phones) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }
}
