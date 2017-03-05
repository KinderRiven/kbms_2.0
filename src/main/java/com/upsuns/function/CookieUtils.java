package com.upsuns.function;

import javax.servlet.http.Cookie;

/*  Created by KinderRiven on 2017/3/3. */
public class CookieUtils {

    public static String getValueByName(Cookie[] cookies, String name){

        for(Cookie cookie : cookies){
            if(cookie.getName().equals(name) == true){
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void deleteValueByName(Cookie[] cookies, String name){

    }
}
