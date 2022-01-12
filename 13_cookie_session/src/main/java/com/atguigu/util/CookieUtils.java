package com.atguigu.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

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
