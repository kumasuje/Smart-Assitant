package edu.iu.smart.assistance.service;

import edu.iu.smart.assistance.helper.QuestionFactory;
import edu.iu.smart.assistance.helper.UserInfo;
import edu.iu.smart.assistance.parser.InputParser;
import edu.iu.smart.assistance.parser.SubjectParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Sujeet on 4/19/17.
 */
@Service
public class SuggestAnswer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InputParser inputParser;

    @Autowired
    private SubjectParser subjectParser;

    @Autowired QuestionFactory questionFactory;

    @Autowired
    private UserInfo userInfo;

    public String processInput(String content){

        logger.info("parsing content '{}'",content);
        List<String> inputSet = inputParser.getParseredSet(content);
        logger.info("size of parse inout {}",inputSet.size());
        String subject = null;
        if(questionFactory.onePartQuestion(inputSet.get(0))){

            subject = subjectParser.getSubject(new HashSet<>(inputSet));
        }

        return userInfo.getAnswerPerObjective(subject);

    }

}
