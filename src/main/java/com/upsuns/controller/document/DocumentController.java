package com.upsuns.controller.document;

import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import com.upsuns.service.document.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

        //get user
        User user = (User) session.getAttribute("user");

        //service
        docService.uploadFile(file, savePath, user, Integer.parseInt(curId));
        result.put("result", "yes");
        return result;
    }
}
