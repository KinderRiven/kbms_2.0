package com.upsuns.controller.test;

import com.upsuns.function.SolrUtils;
import com.upsuns.po.user.User;
import com.upsuns.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Created by KinderRiven on 2017/2/26.
 */
@Controller
public class TestController {

    @RequestMapping("/solr_query.action")
    public void getNode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{
        SolrUtils.queryTest("java");
    }
}
