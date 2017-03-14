package com.upsuns.function;


import com.upsuns.po.document.Document;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

/*Created by KinderRiven on 2017/3/4.*/
public class SolrUtils {

    private static String clientUrl = "http://localhost:8983/solr/document/";
    private static SolrClient solrClient;

    static{
        solrClient = new HttpSolrClient.Builder(clientUrl).build();
    }

    //query test
    public static void queryTest(String value) throws Exception{

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("q", value);

        QueryResponse response = solrClient.query(solrQuery);
        List<Document> docs = response.getBeans(Document.class);

    }

    public static List<Document> queryDocument(String query) throws Exception{

        SolrQuery solrQuery = new SolrQuery();

        //solve query
        String []params = query.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < params.length; i++){
            String param;
            if(i == 0) param = "name:" + params[i] + " OR content:" + params[i];
            else param = " OR name:" + params[i] + " OR content:" + params[i];
            stringBuilder.append(param);
        }
        solrQuery.set("q", stringBuilder.toString());
        //只返回ID、名称、内容
        solrQuery.set("fl", "name id content");

        //highlight
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("name");
        solrQuery.addHighlightField("content");
        solrQuery.setHighlightSimplePre("<font color=\"red\">");
        solrQuery.setHighlightSimplePost("</font>");
        solrQuery.setHighlightSnippets(2);
        solrQuery.setHighlightFragsize(50);

        QueryResponse response = solrClient.query(solrQuery);
        Map<String, Map<String, List<String>>> map = response.getHighlighting();
        List<Document> docs = response.getBeans(Document.class);

        for(Document doc : docs) {
            String id = doc.getId().toString();
            Map<String, List<String>> mmap = map.get(id);

            List<String> hlNameList = mmap.get("name");
            List<String> hlContentList = mmap.get("content");
            String hlName = "";
            String hlContent = "";

            if (hlNameList != null) {
                for (String name : hlNameList) {
                    hlName += name;
                }
            }
            if (hlContentList != null) {
                for (String content : hlContentList) {
                    hlContent += content;
                }
            }
            doc.setHlName(hlName);
            doc.setHlContent(hlContent);

            String content = doc.getContent();
            if(content != null)
                doc.setContent(content.substring(0, Math.min(80, content.length())));
        }
        return docs;
    }

    //index
    public static void indexDocument(Document document) throws Exception{
        solrClient.addBean(document);
        solrClient.commit();
    }
}
