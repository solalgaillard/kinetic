package qinetic.model;

import java.util.Map;
import java.util.HashMap;

public class Message {
    private final Map<String, String> message;

    public Message() {
        message = new HashMap<String, String>();
        message.put("text", "Blah");
    }

    public Map<String, String> getMessage() {
        return message;
    }
}