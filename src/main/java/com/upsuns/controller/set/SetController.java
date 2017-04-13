package com.upsuns.controller.set;

/*
 * Created by KinderRiven on 2017/4/8.
 */

import com.upsuns.function.CookieUtils;
import com.upsuns.po.node.Node;
import com.upsuns.po.set.BookSet;
import com.upsuns.po.set.SetMap;
import com.upsuns.service.set.SetMapService;
import com.upsuns.service.set.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SetController {

    @Autowired
    private SetService setService;

    @Autowired
    private SetMapService setMapService;


    @RequestMapping("/create_book_set.action")
    @ResponseBody
    public Map<String, String> createBookSet(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception {

        Map<String, String> ret = new HashMap<String, String>();

        String name = request.getParameter("set_name");
        String description = request.getParameter("set_description");

        Cookie[] cookies = request.getCookies();
        String username = CookieUtils.getValueByName(cookies, "username");

        if(username != null){
            setService.createBookSet(name, description, username);
            ret.put("result", "yes");
        }
        else{
            ret.put("result", "no");
        }
        return ret;
    }

    @RequestMapping("/get_book_set.action")
    @ResponseBody
    public List<BookSet> getBookSet(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception {

        List<BookSet> bookSets;

        Cookie[] cookies = request.getCookies();
        String username = CookieUtils.getValueByName(cookies, "username");

        if(username != null){
            bookSets = setService.getBookSetByUserName(username);
        }
        else{
            bookSets = null;
        }
        return bookSets;
    }

    @RequestMapping("/add_doc_set.action")
    @ResponseBody
    public Map<String, String> addDocToSet(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        Map<String, String> ret = new HashMap<String, String>();

        String setId = request.getParameter("set_id");
        String nodeId = request.getParameter("node_id");

        Cookie[] cookies = request.getCookies();
        String username = CookieUtils.getValueByName(cookies, "username");

        if(setId != null && nodeId != null && username != null){
            setMapService.addNodeToSet(Integer.parseInt(nodeId),
                    Integer.parseInt(setId), username);
            ret.put("result", "yes");
        } else{
            ret.put("result", "no");
        }
        return ret;
    }


    @RequestMapping("/get_set_content.action")
    @ResponseBody
    public List<Node> getSetContent(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        List<Node> nodes = new ArrayList<Node>();
        String setId = request.getParameter("set_id");

        if(setId != null){
            nodes = setMapService.getNodeFromSet(Integer.parseInt(setId));
        }
        return nodes;
    }

    @RequestMapping("/get_set_info.action")
    @ResponseBody
    public BookSet getSetInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        BookSet bookSet = null;
        String setId = request.getParameter("set_id");
        if(setId != null){
            bookSet = setService.getBookSetById(Integer.parseInt(setId));
        }
        return bookSet;
    }

    @RequestMapping("/upload_set_img.action")
    @ResponseBody
    public Map<String, String> uploadImage(HttpServletRequest request,
                                           HttpServletResponse response, HttpSession session,
                                           @RequestParam(value = "avatar_file") MultipartFile file)
            throws Exception {

        Map<String, String> ret = new HashMap<String, String>();

        String json = request.getParameter("avatar_data");
        System.out.println(json);
        Cookie[] cookies = request.getCookies();
        String saveRoot = request.getServletContext().getRealPath("/") + "/resource/image/set/";

        if(file == null) {
            System.out.println("上传封面为空");
        } else{
            setService.uploadSetImage(file, json, saveRoot);
            ret.put("result", "yes");
        }
        return ret;
    }
}
