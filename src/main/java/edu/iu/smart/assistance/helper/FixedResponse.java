package edu.iu.smart.assistance.helper;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sujeet on 4/30/17.
 */
@Service
public class FixedResponse {

    public FixedResponse() {

        fixedResponse.put("hey","/gif hey");
        fixedResponse.put("hi","/gif hello");
        fixedResponse.put("hello","/gif hi");

        fixedResponse.put("good night","/gif good night");
        fixedResponse.put("goodnight","/gif good night");
        fixedResponse.put("good day","/gif good day");


        fixedResponse.put("bye","/gif bye");
        fixedResponse.put("cya","/gif cya");
    }

    Map<String,String> fixedResponse = new HashMap<String,String>();

    public String hasFixedResponse(String content){

        if(! fixedResponse.containsKey(content)) return null;

        return fixedResponse.getOrDefault(content,null);
    }
}
