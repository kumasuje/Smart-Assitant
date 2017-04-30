package edu.iu.smart.assistance.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sujeet on 4/18/17.
 */
@Service
public class UserInfo {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Map<String,String> userInfo;

    UserInfo(){

        userInfo = new HashMap<String, String>();
        userInfo.put("email","If you are looking for my email id, my id is karan_lamba@iu.edu");
        userInfo.put("address","If you are looking for my address, my address 2679 H Park Doral");
        userInfo.put("number","If you are looking for my number, my number is 8123257361");
        userInfo.put("notfree","It seems like I have sometime in calendar. May be some other time ? ");
    }

    public String getAnswerPerObjective(String objective){

        logger.info("Finding answer for key '{}'",objective);
        String result = userInfo.get(objective);
        logger.info("Found result is '{}'",result);
        return result;
    }
}
