package edu.iu.smart.assistance.helper;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sujeet on 4/30/17.
 */
@Service
public class FixedResponse {

    public FixedResponse() {

        fixedResponse.put("hey","https://giphy.com/gifs/breakfast-egg-cook-3oGRFh9szq10x1HAys");
        fixedResponse.put("hi","https://giphy.com/gifs/hello-hi-dzaUX7CAG0Ihi");
        fixedResponse.put("hello","https://giphy.com/gifs/kZzY6eKKPdIjK");

        fixedResponse.put("good night","https://giphy.com/gifs/disney-disney-gif-pinocchio-jiminy-cricket-mguPrVJAnEHIY");
        fixedResponse.put("goodnight","https://giphy.com/gifs/tvland-goodnight-4NEbxVNYIxraM");
        fixedResponse.put("good day","https://giphy.com/gifs/cat-cute-haveagoodday-OojQx4M3zYUOk");


        fixedResponse.put("bye","https://giphy.com/gifs/realitytvgifs-bye-married-to-medicine-dr-jackie-11krT7xA8uuLbG");
        fixedResponse.put("cya","https://giphy.com/gifs/reactiongifs-rrLt0FcGrDeBq");
        fixedResponse.put("whats up","https://giphy.com/gifs/robin-williams-wassup-eoVusT7Pi9ODe");
        fixedResponse.put("sup","https://giphy.com/gifs/foxsports-nba-mood-jr-smith-TiytUXsnUDfsk");


    }

    Map<String,String> fixedResponse = new HashMap<String,String>();

    public String hasFixedResponse(String content){

        if(! fixedResponse.containsKey(content)) return null;

        return fixedResponse.getOrDefault(content,null);
    }
}
