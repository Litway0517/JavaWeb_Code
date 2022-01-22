package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonTest2 {

    @Test
    public void test1() {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person(1, "test1"));
        people.add(new Person(2, "test2"));
        System.out.println(people);


        Gson gson = new Gson();

        // 将List对象转换为JSON字符串
        String peopleListToString = gson.toJson(people);
        System.out.println(peopleListToString);

        // 将JSON字符串一模一样转换回List<Person>
        // gson.fromJson();

    }






}
