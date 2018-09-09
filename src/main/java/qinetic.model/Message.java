package qinetic.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Message {
    private final ArrayList<Object> message;

    public Message() {
        message = new ArrayList<Object>();
        HashMap<String, String> tmp = new HashMap<String, String>();
        tmp.put("text", "Blah");
        message.add("texttest");
        message.add(tmp);
    }

    public ArrayList<Object> getMessage() {
        return message;
    }
}