package edu.iu.smart.assistance.service;

import edu.iu.smart.assistance.helper.QuestionFactory;
import edu.iu.smart.assistance.helper.UserInfo;
import edu.iu.smart.assistance.parser.InputParser;
import edu.iu.smart.assistance.parser.PointOfViewParser;
import edu.iu.smart.assistance.parser.SubjectParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sujeet on 4/29/17.
 */
@Service
public class RulesBasedReasoning {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InputParser inputParser;

    @Autowired
    private SubjectParser subjectParser;

    @Autowired
    QuestionFactory questionFactory;

    @Autowired
    private UserInfo userInfo;


    public String matchRules(String content){


        logger.info("parsing content '{}'",content);
        List<String> input = inputParser.getParseredSet(content);
        logger.info("size of parse inout {}",input.size());
        String subject = null;
        Set<String> inputSet = new HashSet<String>(input);
        if(questionFactory.onePartQuestion(input.get(0)) && PointOfViewParser.isFirstPerson(inputSet)
                && ! PointOfViewParser.isSecondPerson(inputSet)){

            //Rule 1 Triggered -- Direct question
            logger.info("Rule 1 Triggered");
            subject = subjectParser.getSubject(inputSet);
            return userInfo.getAnswerPerObjective(subject);
        } else if(questionFactory.twoPartQuestion(input.get(0)) && PointOfViewParser.isFirstPerson(inputSet)
                && PointOfViewParser.isSecondPerson(inputSet)){

            //Rule 2 Triggered -- Indirect Question
            logger.info("Rule 2 Triggered");
            subject = subjectParser.getSubject(inputSet);
            return userInfo.getAnswerPerObjective(subject);
        }

        return "";
    }
}
