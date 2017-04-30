package edu.iu.smart.assistance.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sujeet on 4/29/17.
 */
public class ConstantResponse {

    public static Map<String,String> map = new HashMap<String,String>();

    public static void addACases(String key, String value){

        map.put(key,value);
    }

    public static String hasACased(String key){

        return map.getOrDefault(key,null);
    }
}
