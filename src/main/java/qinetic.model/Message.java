package qinetic.model;

import java.util.Map;
import java.util.HashMap;

public class Message {
    private final Map<String, String> message;

    public Message() {
        message = new HashMap<String, String>();
        message.put("text", "Blah");
        message.put("reference", "Bouah ah");
        message.put("text", "Bouah ah");
        message.put("list", "bidule");
    }

    public Map<String, String> getMessage() {
        return message;
    }
}