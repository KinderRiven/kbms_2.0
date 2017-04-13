package com.upsuns.controller.hash;

import com.upsuns.mapper.hash.SimListMapper;
import com.upsuns.po.document.Document;
import com.upsuns.service.hash.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by KinderRiven on 2017/4/13.
 */
@Controller
public class HashController {


    @Autowired
    private HashService hashService;

    @RequestMapping("/get_sim_list.action")
    @ResponseBody
    public List<Document> getSimList
            (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{

        List<Document> docs = new ArrayList<Document>();
        String docId = request.getParameter("doc_id");

        if(docId != null){
            docs = hashService.getSimDocList(Integer.parseInt(docId));
        }
        return docs;
    }
}
