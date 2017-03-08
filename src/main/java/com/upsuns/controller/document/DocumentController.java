package com.upsuns.controller.document;

import com.upsuns.function.CookieUtils;
import com.upsuns.function.SolrUtils;
import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import com.upsuns.service.document.DocService;
import org.apache.zookeeper.server.SessionTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/*
 * Created by KinderRiven on 2017/2/26.
 */
@Controller
public class DocumentController {

    @Autowired
    private DocService docService;

    @RequestMapping("/file_upload.action")
    @ResponseBody
    public Map<String, String> fileUpload(
            @RequestParam("file") MultipartFile file,   //upload node
            @RequestParam("cur_id") String curId,       //current id
            HttpServletRequest request,                 //request
            HttpServletResponse response,               //response
            HttpSession session                         //session
    ) throws Exception {
        //result map
        Map<String, String> result = new HashMap<String, String>();

        //get save path
        String saveRoot = request.getServletContext().getRealPath("/") + "save/";
        String uuid = UUID.randomUUID().toString();
        String docName = file.getOriginalFilename();
        String savePath = saveRoot + uuid + "-" + docName;

        //user cookie
        Cookie[] cookies = request.getCookies();
        String username = CookieUtils.getValueByName(cookies, "username");
        String password = CookieUtils.getValueByName(cookies, "password");

        //service
        if(username != null) {
            boolean ret = docService.uploadFile(file, savePath, username, password , Integer.parseInt(curId));
            if(ret)
                result.put("result", "yes");
            else
                result.put("result", "no");
        } else
            result.put("result", "no");

        return result;
    }

    @RequestMapping("/doc_search.action")
    @ResponseBody
    public List<Document> documentQuery
            (HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws Exception{

        List<Document> result = new ArrayList<Document>();
        List<Document> docs;
        String query = request.getParameter("search_value");

        //service
        docs = docService.solrQueryDocument(query);

        session.setAttribute("search_list", docs);
        session.setAttribute("query", query);

        for(int i = 0; i < 10 && i < docs.size(); i++){
            result.add(docs.get(i));
        }
        return result;
    }

    @RequestMapping("/query_list.action")
    @ResponseBody
    public List<Document> getDocumentList(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws Exception{

        List<Document> docs = new ArrayList<Document>();
        String sStart = request.getParameter("start");
        String sEnd = request.getParameter("end");

        if(sStart != null && sEnd != null){
            Integer start = Integer.parseInt(sStart);
            Integer end = Integer.parseInt(sEnd);
            List<Document> queryDocs = (List<Document>) session.getAttribute("search_list");

            for(int i = start; i < end && i < queryDocs.size(); i++){
                docs.add(queryDocs.get(i));
            }
        }
        return docs;
    }
}
