package edu.iu.smart.assistance.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Sujeet on 4/18/17.
 */
@Service
public class SubjectParser {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getSubject(HashSet<String> hashedInput){

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
        }
        logger.info("No subject found ");
        return null;
    }
}
