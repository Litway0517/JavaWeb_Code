package com.atguigu.json;


import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * json测试
 *
 * @author DELL_
 * @date 2022/01/22
 */
public class JsonTest {

    /**
     * 单个JavaBean对象 与 JSON 对象之间的相互转换
     *
     * java bean json
     */
    @Test
    public void javaBeanToJson() {

        // 创建一个JavaBean对象
        Person person = new Person(1, "litway");

        // 创建Gson实例
        Gson gson = new Gson();

        /*
            调用实例的方法 toJson是将Bean转换为JSON字符串.
            toJSON方法: 将Bean转换为JSON字符串
            toString方法: 将Bean对象转换为字符串
         */
        String personToString = gson.toJson(person);
        System.out.println(personToString);
        // {"id":1,"name":"litway"}

        // 将字符串转换为Bean对象
        Person person1 = gson.fromJson(personToString, Person.class);
        System.out.println(person1);
        // Person{id=1, name='litway'}
    }


    /**
     * 多个JavaBean对象 与 JSON之间的转换
     * List 与 JSON之间的转换
     *
     */
    @Test
    public void arrToJSON() {
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person(1, "test01"));
        personList.add(new Person(2, "test02"));

        Gson gson = new Gson();

        // List集合转换为JSON字符串
        String personListToString = gson.toJson(personList);
        System.out.println(personListToString);
        // [{"id":1,"name":"test01"},{"id":2,"name":"test02"}]


        // 尝试将JSON字符串转换回List
        // 这一行是不行的, 根据输出就知道. 这个class的传入不合适. 需要重新写一个类, 然后继承自google提供的反射类TypeToken
        List<Person> list = gson.fromJson(personListToString, personList.getClass());
        System.out.println(list);

        // Person person = list.get(0);
        // System.out.println(person);


        // 重新转换
        List<Person> jsonToPersonList = gson.fromJson(personListToString, new PersonListType().getType());
        System.out.println(jsonToPersonList);

    }



}
