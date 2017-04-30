package edu.iu.smart.assistance.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sujeet on 4/17/17.
 */
@Service
public class QuestionFactory {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    static Set<String> onePartQuestionSet = new HashSet<String>();
    static Set<String> twoPartQuestionSet = new HashSet<String>();
    static Set<String> threePartQuestionSet = new HashSet<String>();

    QuestionFactory(){

        onePartQuestionSet.add("what");
        onePartQuestionSet.add("when");
        onePartQuestionSet.add("who");
        onePartQuestionSet.add("whom");
        onePartQuestionSet.add("why");
        onePartQuestionSet.add("how");

        twoPartQuestionSet.add("do");
        twoPartQuestionSet.add("can");
        twoPartQuestionSet.add("could");
        twoPartQuestionSet.add("will");
        twoPartQuestionSet.add("would");
        twoPartQuestionSet.add("did");
        twoPartQuestionSet.add("have");
        twoPartQuestionSet.add("shall");
        twoPartQuestionSet.add("should");

        threePartQuestionSet.add("are");
    }

    public boolean onePartQuestion(String word){
        logger.info("checking first word to determine Direct question - '{}'",word);
        if(onePartQuestionSet.contains(word)){
            logger.info("With first letter '{}' , Sentence is a question ",word);
            return true;
        }
        logger.info("With first letter '{}' , Sentence  not is a question ",word);
        return false;

    }

    public boolean twoPartQuestion(String word){

        logger.info("checking first word to determine Indirect question - '{}'",word);
        if(twoPartQuestionSet.contains(word)){
            logger.info("With first letter '{}' , Sentence is a question ",word);
            return true;
        }
        logger.info("With first letter '{}' , Sentence  not is a question ",word);
        return false;

    }

    public boolean threePartQuestion(String word){

        logger.info("checking first word to determine Other question - '{}'",word);
        if(threePartQuestionSet.contains(word)){
            logger.info("With first letter '{}' , Sentence is a question ",word);
            return true;
        }
        logger.info("With first letter '{}' , Sentence  not is a question ",word);
        return false;

    }

}
