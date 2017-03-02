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
    public void getNode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        //get request
        String nid =  request.getParameter("node_id");
        User user = (User) session.getAttribute("user");
        String xml = "";

        if(nid != null){

            Integer id = Integer.parseInt(nid);
            List<Node> nodeList = nodeService.getFolderList(user, id);
            Integer preNodeId = nodeService.getPreNodeId(id);

            //add in xml to return
            xml += "<root>";
            xml += "<node>";
            xml += "<id>"; xml += preNodeId.toString() ;xml += "</id>";
            xml += "<name>...</name>";
            xml += "<type>"; xml += "folder"; xml += "</type>";
            xml += "<modify>-</modify>";
            xml += "<info>上级目录</info>";
            xml += "</node>";
            for(Node node: nodeList){
                xml += "<node>";
                //id
                xml += "<id>"; xml += node.getId().toString() ;xml += "</id>";
                //name
                xml += "<name>"; xml += node.getName(); xml += "</name>";
                //type
                xml += "<type>"; xml += node.getType(); xml += "</type>";
                //modify
                xml += "<modify>"; xml += node.getModifyTime().toString(); xml += "</modify>";
                //info
                xml += "<info>"; xml += node.getInfo(); xml += "</info>";
                xml += "</node>";
            }
            //
            xml += "</root>";
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(xml);
        } else{

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
