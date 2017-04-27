package edu.iu.smart.assistance.controller;

import edu.iu.smart.assistance.model.PayloadModel;
import edu.iu.smart.assistance.service.SuggestAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sujeet on 4/19/17.
 */
@RestController
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SuggestAnswer suggestAnswer;


    @RequestMapping(value="reply",method = RequestMethod.GET)
    public ResponseEntity<String> replyBack(String content){

        logger.info("Query Request is '{}'",content);
        String queryResult = suggestAnswer.processInput(content);

        HttpHeaders responseHeaders = new HttpHeaders();
        if(queryResult == null) {
            responseHeaders.set("auto-response", "false");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(responseHeaders).body(null);
        }else {
            responseHeaders.set("auto-response", "true");

        }

        return ResponseEntity.ok(queryResult);
    }

    @RequestMapping(value = "reply",method = RequestMethod.POST)
    public String replyBackWithPost(@RequestBody PayloadModel payloadModel){

        return "";
    }

}
