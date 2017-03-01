package com.upsuns.function;

/* reated by KinderRiven on 2017/3/1. */

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// text utils
// using tika get node text
public class TextUtils {

    //single class
    private static TextUtils textUtils = new TextUtils();

    private TextUtils(){};
    //get class
    public static TextUtils getTextUtils(){
        return textUtils;
    }

    //get node text
    public String getFileText(String path) throws Exception{

        InputStream input = new FileInputStream(path);
        BodyContentHandler textHandler = new BodyContentHandler();
        Parser parser = new AutoDetectParser();
        ParseContext context = new ParseContext();
        Metadata metadata = new Metadata();

        try {
            parser.parse(input, textHandler, metadata, context);// 执行解析过程
        } catch (NullPointerException e) {
            try {
                input.close();
            } catch (IOException e1) {
                return null;
            }
        }   catch (IOException e)   {   return null;   }
            catch (SAXException e)  {   return null;   }
            catch (TikaException e) {   return null;   }
        input.close();
        return textHandler.toString();
    }
}
