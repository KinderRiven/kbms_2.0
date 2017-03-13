package com.upsuns.service.document;

import com.upsuns.function.SolrUtils;
import com.upsuns.function.TagUtils;
import com.upsuns.function.TextUtils;
import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.mapper.tag.DocTagMapper;
import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.tag.DocTag;
import com.upsuns.po.tag.Tag;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public class DocServiceImpl implements DocService{

    @Autowired
    private DocMapper docMapper;

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DocTagMapper docTagMapper;

    //upload node
    public Document uploadFile(MultipartFile file, String savePath,
                           String username, String password, Integer curId) throws Exception{
        //get user
        User user = userMapper.selectByUserName(username);
        if(user == null) return null;

        //save node
        Document document = new Document(file.getOriginalFilename(), savePath);
        String type = TextUtils.getFileSuffix(document.getName());
        if(type != null)
            document.setType(type);
        else
            document.setType("file");
        File saveFile = new File(document.getPath());
        file.transferTo(saveFile);

        //read node
        String content = TextUtils.getFileText(document.getPath());
        document.setContent(content);

        //add document info
        docMapper.insertDoc(document);

        //solr
        SolrUtils.indexDocument(document);

        //add node
        //new node
        Node node = new Node();
        node.setUid(user.getId());
        if(type != null)
            node.setType(type);
        else
            node.setType("file");

        node.setPre(curId);
        node.setFileId(document.getId());
        node.setName(document.getName());
        nodeMapper.insertNode(node);

        return document;
    }

    public List<Document> solrQueryDocument(String query) throws Exception{

        List<Document> docs = SolrUtils.queryDocument(query);

        for(Document doc : docs) {

            Integer id = doc.getId();
            List<String> tags = new ArrayList<String>();
            List<DocTag> docTags = docTagMapper.selectTagsByDocId(id);

            for (DocTag docTag : docTags) {
                tags.add(docTag.getTagName());
            }
            doc.setTags(tags);
        }

        return docs;
    }
}
