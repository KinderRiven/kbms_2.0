package com.upsuns.controller.user;


import com.upsuns.po.user.User;
import com.upsuns.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by KinderRiven on 2017/2/26.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //user register
    @RequestMapping("/user_register.action")
    @ResponseBody
    public Map<String, String> userRegister(HttpServletRequest request, HttpServletResponse response)
            throws Exception{

        Map<String, String> map = new HashMap<String, String>();

        //get data
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String nickname = request.getParameter("nick_name");

        //register service
        userService.register(username, password, nickname);

        map.put("result", "yes");
        return map;
    }

    //user login
    @RequestMapping("/user_login.action")
    @ResponseBody
    public Map<String, String> userLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
    ) throws Exception{

        Map<String, String> map = new HashMap<String, String>();
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_password");

        //login service
        User user = userService.login(username, password);

        if(user != null) {
            session.setAttribute("user", user);
            //创建cookie
            Cookie usrCookie = new Cookie("username", username);
            Cookie pwdCookie = new Cookie("password", password);
            response.addCookie(usrCookie);
            response.addCookie(pwdCookie);
            map.put("result", "yes");
        }   else{
            map.put("result", "no");
        }
        return map;
    }

    //logout
    @RequestMapping("/user_logout.action")
    @ResponseBody
    public Map<String, String> userLogout(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception{

        Map<String, String> map = new HashMap<String, String>();

        //清除用户cookie
        Cookie userCookie = new Cookie("username", null);
        userCookie.setMaxAge(0);
        Cookie pwdCookie = new Cookie("password", null);
        pwdCookie.setMaxAge(0);

        //添加cookie
        response.addCookie(userCookie);
        response.addCookie(pwdCookie);
        //remove from session
        session.removeAttribute("user");

        map.put("result", "yes");
        return map;
    }

}
