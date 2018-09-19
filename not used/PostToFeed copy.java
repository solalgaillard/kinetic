package qinetic.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import qinetic.service.JWTToId;
import java.util.UUID;
import java.time.Instant;


public class PostToFeed {

    private final String postUUID;
    private final String userUUID;
    private final String userName;
    private final String userPicture;
    private final Long timestamp;

    private final ArrayList<Object> message;

    public PostToFeed(String accessToken, ArrayList<Object> aMessage){
        JWTToId JWTConverter = new JWTToId(accessToken);

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        Instant instant = Instant.now();

        postUUID = randomUUIDString;
        userUUID = JWTConverter.getUser();
        userName = JWTConverter.getUsername();
        userPicture = JWTConverter.getPic();
        timestamp = instant.toEpochMilli();
        message = aMessage;
    }

    public String getPostUUID() {
        return postUUID;
    }
    public String getUserUUID() {
        return userUUID;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPicture() {
        return userPicture;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public ArrayList<Object> getMessage() {
        return message;
    }
}