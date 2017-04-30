package edu.iu.smart.assistance.service;

import edu.iu.smart.assistance.helper.QuestionFactory;
import edu.iu.smart.assistance.helper.UserInfo;
import edu.iu.smart.assistance.model.WeekModel;
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

    @Autowired
    private CaseBasedReasoning caseBasedReasoning;

    public String processInput(String content){

        logger.info("parsing content '{}'",content);
        List<String> inputSet = inputParser.getParseredSet(content);
        logger.info("size of parse inout {}",inputSet.size());
        String subject = null;

        //Learning From Past
        if(caseBasedReasoning.findCaseFromPast(content) != null){

            return caseBasedReasoning.findCaseFromPast(content);
        }

        if(questionFactory.onePartQuestion(inputSet.get(0)) || questionFactory.twoPartQuestion(inputSet.get(0))){

            subject = subjectParser.getSubject(new HashSet<>(inputSet));
        }

        if(questionFactory.threePartQuestion(inputSet.get(0))){

            HashSet<String> inputSetLocal = new HashSet<>(inputSet);
            subject = subjectParser.getSubject(inputSetLocal);
            if(subject.equals("free") && subjectParser.hasDay(inputSetLocal) != null && subjectParser.hasTime(inputSetLocal) !=null){

                Integer day = subjectParser.hasDay(inputSetLocal);
                WeekModel.DayModel[] weekDays = WeekModel.getDays();
                Integer time = subjectParser.hasTime(inputSetLocal);
                subject = (weekDays[day].hours[time] == true ) ? "notfree" : "free" ;
            }

        }

        return userInfo.getAnswerPerObjective(subject);

    }

    public void addNewCases(String content){

    caseBasedReasoning.addANewCase(content);

    }

}
