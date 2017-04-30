package edu.iu.smart.assistance.model;

/**
 * Created by Sujeet on 4/30/17.
 */
public class SlackResponse {

    private String response_type;
    private String text;

    public SlackResponse() {
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
