package com.upsuns.function;


import com.upsuns.po.document.Document;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

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
        System.out.println(docs.size());
    }

    //index
    public static void indexDocument(Document document) throws Exception{
        solrClient.addBean(document);
        solrClient.commit();
    }
}
