package edu.iu.smart.assistance.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sujeet on 4/18/17.
 */
@Service
public class SubjectParser {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getSubject(Set<String> hashedInput){

        logger.info("Finding the Subject ");
        if(hashedInput.contains("email") || hashedInput.contains("emailid")){
            logger.info("Found subject is 'email'");
            return "email";
        }else if(hashedInput.contains("address")){
            logger.info("Found subject is 'Address'");
            return "address";
        }else if(hashedInput.contains("number") || hashedInput.contains("phone")){
            logger.info("Found subject is 'number'");
            return "number";
        }else if(hashedInput.contains("free")){
            logger.info("Found subject is 'free'");
            return "free";
        }
        logger.info("No subject found ");
        return null;
    }

    public Integer hasDay(Set<String> hashedInput){

        logger.info("Finding the day ");
        if(hashedInput.contains("today")){
            return 0;
        }else if (hashedInput.contains("tomorrow")){
            return 1;
        }

        return null;
    }

    public Integer hasTime(Set<String> hashedInput){

        logger.info("Finding the Time ");
        List<Integer> list = new ArrayList<Integer>();

        for (String content : hashedInput) {
            boolean flag = false;
            for(int i =0; i < content.length(); i++){

                if(Character.isDigit(content.charAt(i))){
                    flag = true;
                }else {
                    flag = false;
                }
            }
            if(flag) {
                list.add(Integer.parseInt(content));
            }
        }
        return (list.size() == 0 ) ? null : list.get(0);
    }

}
