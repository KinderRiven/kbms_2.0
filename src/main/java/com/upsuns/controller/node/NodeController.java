package com.upsuns.controller.node;

import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import com.upsuns.service.node.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Created by KinderRiven on 2017/3/1. */

@Controller
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @RequestMapping("/get_node.action")
    public @ResponseBody String getNode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        String nid =  request.getParameter("node_id");
        User user = (User) session.getAttribute("user");
        String xml = "";

        if(nid != null){

            Integer id = Integer.parseInt(nid);
            List<Document> docList = nodeService.getFolderList(user, id);
            //add in xml to return
            xml += "<root>";
            for(Document doc : docList){
                System.out.println(doc.getName());
            }
            //
            xml += "</root>";
            return xml;
        } else{
            //System.out.println("参数不全");
            return null;
        }
    }

    @RequestMapping("/get_root.action")
    @ResponseBody
    public Map<String, String> getRoot(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        Map<String, String> root = new HashMap<String, String>();
        User user = (User) session.getAttribute("user");
        Node node = nodeService.getRootNode(user);

        root.put("root_id", node.getId().toString());
        return root;
    }

}
