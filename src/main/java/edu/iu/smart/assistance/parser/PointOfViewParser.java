package edu.iu.smart.assistance.parser;

import java.util.Set;

/**
 * Created by Sujeet on 4/18/17.
 */
public class PointOfViewParser {

    public static boolean isSecondPerson(Set<String> parsedInput){

        if(parsedInput.contains("you") || parsedInput.contains("your") || parsedInput.contains("yours")) return true;
        return false;
    }

    public static boolean isFirstPerson(Set<String> parsedInput){

        if(parsedInput.contains("i") || parsedInput.contains("me") || parsedInput.contains("we")
                || parsedInput.contains("us") || parsedInput.contains("mine") || parsedInput.contains("my")
                || parsedInput.contains("our") || parsedInput.contains("ours")) return true;
        return false;
    }

    public static boolean isThirdPerson(Set<String> parsedInput){

        if(parsedInput.contains("he") || parsedInput.contains("she") || parsedInput.contains("it")
                || parsedInput.contains("him") || parsedInput.contains("her") || parsedInput.contains("they")
                || parsedInput.contains("them") || parsedInput.contains("his") || parsedInput.contains("her")
                || parsedInput.contains("hers") || parsedInput.contains("their") || parsedInput.contains("theirs")) return true;
        return false;
    }

}
