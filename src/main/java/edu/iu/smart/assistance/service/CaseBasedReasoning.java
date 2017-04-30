package edu.iu.smart.assistance.service;

import edu.iu.smart.assistance.helper.ConstantResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Sujeet on 4/29/17.
 */

@Service
public class CaseBasedReasoning {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addANewCase(String content){

        String[] input= content.trim().split(",");

        if(input.length <= 1) return false;
        logger.info("Adding new case with key '{}' and value '{}' ",input[0],input[1]);
        ConstantResponse.addACases(input[0],input[1]);
        return true;
    }

    public String findCaseFromPast(String content){

        logger.info("Finding Cases for key '{}' "+content);
        return ConstantResponse.hasACased(content);
    }

}
