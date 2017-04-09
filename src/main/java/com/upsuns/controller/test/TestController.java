package com.upsuns.controller.test;

import com.upsuns.po.set.BookSet;
import com.upsuns.service.set.SetMapService;
import com.upsuns.service.set.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Created by KinderRiven on 2017/2/26.
 */
@Controller
public class TestController {

    @Autowired
    private SetService setService;

    @Autowired
    private SetMapService setMapService;

    @RequestMapping("/test.action")
    @ResponseBody
    public void runTest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

    }
}
