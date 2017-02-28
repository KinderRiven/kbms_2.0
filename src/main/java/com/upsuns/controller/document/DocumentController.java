package com.upsuns.controller.document;

import com.upsuns.po.document.Document;
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
import java.io.File;
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
            @RequestParam("file") MultipartFile file,   //upload file
            @RequestParam("uid") String userId,         //upload user
            HttpServletRequest request,                 //request
            HttpServletResponse response                //response
    ) throws Exception {

        //result map
        Map<String, String> result = new HashMap<String, String>();

        //get file info
        String saveRoot = request.getServletContext().getRealPath("/") + "save/";
        String uuid = UUID.randomUUID().toString();
        String docName = file.getOriginalFilename();
        String savePath = saveRoot + uuid + "-" + docName;

        //file save
        File saveFile = new File(savePath);
        file.transferTo(saveFile);

        //new document
        Document document = new Document(docName, savePath);
        //new user
        User user = new User();
        //service
        docService.uploadFile(document, user);

        result.put("result", "yes");
        return result;
    }
}
