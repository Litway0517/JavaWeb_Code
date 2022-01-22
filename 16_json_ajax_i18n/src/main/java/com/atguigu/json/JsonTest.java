package com.atguigu.json;


import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import org.junit.Test;

/**
 * json测试
 *
 * @author DELL_
 * @date 2022/01/22
 */
public class JsonTest {

    /**
     * JavaBean 与 JSON 对象之间的相互转换
     *
     * java bean json
     */
    @Test
    public void JavaBeanToJson() {

        // 创建一个JavaBean对象
        Person person = new Person(1, "litway");

        // 创建Gson实例
        Gson gson = new Gson();

        // 调用实例的方法 toJson是将Bean转换为JSON字符串
        String personToString = gson.toJson(person);
        System.out.println(personToString);

        // 将字符串转换为Bean对象
        Person person1 = gson.fromJson(personToString, Person.class);
        System.out.println(person1);
    }





}
