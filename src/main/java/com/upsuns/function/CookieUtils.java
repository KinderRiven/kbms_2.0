package com.upsuns.function;

import javax.servlet.http.Cookie;

/*  Created by KinderRiven on 2017/3/3. */
public class CookieUtils {

    private static CookieUtils cookieUtils = new CookieUtils();

    private CookieUtils(){};

    public static CookieUtils getCookieUtils(){
        return cookieUtils;
    }

    public String getValueByName(Cookie[] cookies, String name){

        for(Cookie cookie : cookies){
            if(cookie.getName().equals(name) == true){
                return cookie.getValue();
            }
        }
        return null;
    }
}
