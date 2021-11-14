package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * web跑龙套
 *
 * @author DELL
 * @date 2021/11/14
 */
public class WebUtils {


    /**
     * 将参数赋值给JavaBean对象
     *
     *  这个方法得参数是一个Map value和一个Object bean对象. 并不是一个HttpServlet request和一个Object bean对象
     *      理由是, 在JavaEE的三层架构中, DAO层 == Service层 == Web层 并不能使用HttpServlet类型的对象.
     *      简而言之, 现在就是为了获取Map中的参数传给Bean对象, 但是这个Map不一定都来自HttpServlet中的request中的Map啊?
     *      还可能来自其他地方, 所以改成Map类型. Map类型是包括HttpServlet中的request.getParameterMap()类型的.
     *
     *  @param value 请求
     *  @param bean    返回的结果类型*/
    public static <T> T copyParamsToBean(Map value, T bean) {

        try {
            System.out.println("注入参数之前 -> " + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入参数之后 -> " + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

}







