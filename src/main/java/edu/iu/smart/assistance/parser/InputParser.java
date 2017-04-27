package edu.iu.smart.assistance.parser;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sujeet on 4/18/17.
 */
@Service
public class InputParser {


    public List<String> getParseredSet(String line){

        List<String> hashedInput = new ArrayList<String>();;

        String[] splitInput = line.split(" ");

        for (String word: splitInput) {
            hashedInput.add(word.toLowerCase());
        }

        return hashedInput;
    }
}
