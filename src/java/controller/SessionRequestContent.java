package controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;


public class SessionRequestContent {

    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public SessionRequestContent() {
        this.requestAttributes = new HashMap<>();
        this.requestParameters = new HashMap<>();
        this.sessionAttributes = new HashMap<>();
    }

    public void extractValues(HttpServletRequest request) {

    }

    public void insertAttributes(HttpServletRequest request) {

    }
}
