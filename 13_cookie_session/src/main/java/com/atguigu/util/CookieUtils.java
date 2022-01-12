package com.atguigu.util;

import javax.servlet.http.Cookie;

/**
 * 饼干跑龙套
 *
 * @author DELL_
 * @date 2022/01/12
 */
public class CookieUtils {

    /**
     * 发现饼干
     *
     * @param name    名字
     * @param cookies 饼干
     * @return {@link Cookie}
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        // 对传入的参数进行判断
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }





}
