package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ajax servlet
 *
 * @author DELL_
 * @date 2022/01/22
 */
public class AjaxServlet extends BaseServlet {


    /**
     * java脚本ajax
     * 接受前端的AJAX请求
     * ajax是指 Asynchronous Javascript And XML(异步JavaScript和XML)
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Ajax请求过来了");

        Person person = new Person(1, "test");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 将person对象转换成JSON字符串格式
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }


    /**
     * j ajax查询
     * j ajax查询
     * j ajax查询
     * jQuery库封装的Ajax请求
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("jQueryAjax   被调用了");

        Person person = new Person(1, "javaScript原生Ajax请求");

        // 将person对象转换成JSON字符串格式
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }


    /**
     * j查询得到
     * jQueryGet
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("jQueryGet   被调用了");

        Person person = new Person(2, "jQueryGet");

        // 将person对象转换成JSON字符串格式
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);

    }

    /**
     * 我查询后
     * jQueryPost
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("jQueryPost   被调用了");

        Person person = new Person(3, "jQueryPost");

        // 将person对象转换成JSON字符串格式
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }

    /**
     * j查询得到json
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("jQueryPost   被调用了");

        Person person = new Person(4, "jQueryGetJSON 固定为GET请求返回的数据固定为JSON");

        // 将person对象转换成JSON字符串格式
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }


    /**
     * jQuerySerialize
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("jQuerySerialize   被调用了");

        Person person = new Person(5, "jQuerySerialize 将表单项的数据全部拼接为name=value&name=value发送");

        // 将person对象转换成JSON字符串格式
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }



}
