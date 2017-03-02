package com.upsuns.controller.user;


import com.upsuns.po.user.User;
import com.upsuns.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/*
 * Created by KinderRiven on 2017/2/26.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //user register
    @RequestMapping("/user_register.action")
    public ModelAndView userRegister(HttpServletRequest request, HttpServletResponse response)
            throws Exception{

        ModelAndView modelAndView = new ModelAndView();

        //get data
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String nickname = request.getParameter("nick_name");

        //register service
        userService.register(username, password, nickname);

        modelAndView.setViewName("/page/login/jsp/login");
        return modelAndView;
    }

    //user login
    @RequestMapping("/user_login.action")
    public ModelAndView userLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
    ) throws Exception{

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter("user_name");
        String password = request.getParameter("user_password");

        //login service
        User user = userService.login(username, password);

        if(user != null) {
            modelAndView.setViewName("/page/space/upload/jsp/upload");
            session.setAttribute("user", user);
        }   else{
            modelAndView.setViewName("/page/login/jsp/login");
        }
        return modelAndView;
    }
}
