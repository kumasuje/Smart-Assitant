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

        fixedResponse.put("hey","/giphy hey");
        fixedResponse.put("hi","/giphy hello");
        fixedResponse.put("hello","/giphy hi");

        fixedResponse.put("good night","/giphy good night");
        fixedResponse.put("goodnight","/giphy good night");
        fixedResponse.put("good day","/giphy good day");


        fixedResponse.put("bye","/giphy bye");
        fixedResponse.put("cya","/giphy cya");
    }

    Map<String,String> fixedResponse = new HashMap<String,String>();

    public String hasFixedResponse(String content){

        if(! fixedResponse.containsKey(content)) return null;

        return fixedResponse.getOrDefault(content,null);
    }
}
