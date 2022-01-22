package com.atguigu.json;


import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Test
    public void mapToJson() {
        HashMap<Integer, Person> peopleMap = new HashMap<Integer, Person>();

        peopleMap.put(1, new Person(1, "test1"));
        peopleMap.put(2, new Person(2, "test2"));
        System.out.println(peopleMap);


        // 将map转换成JSON字符串格式
        Gson gson = new Gson();
        String personMapToString = gson.toJson(peopleMap);
        System.out.println(personMapToString);
        // {"1":{"id":1,"name":"test1"},"2":{"id":2,"name":"test2"}}


        // 将一个JSON字符串转换成原来的Map集合
        Map<Integer, Person> personMap = gson.fromJson(personMapToString, new PersonMapType().getType());
        System.out.println(personMap);

        // 使用匿名内部类格式
        Map<Integer, Person> jsonToPersonMap = gson.fromJson(personMapToString, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(jsonToPersonMap);


    }



}
