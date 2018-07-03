package qinetic.model;

import java.util.ArrayList;

public class HomeFeed {

    private final String postUUID;
    private final String userUUID;
    private final String userName;
    private final String userPicture;
    private final String timestamp;

    private final ArrayList<Message> message;


    public HomeFeed(String userID){
        postUUID = "truc";
        userUUID = userID;
        userName = "Solal Gaillard";
        userPicture = "string/string.jpg";
        timestamp = "10101874";
        message = new ArrayList();
        message.add(new Message());
        message.add(new Message());
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

    public String getTimestamp() {
        return timestamp;
    }

    public ArrayList<Message> getMessage() {
        return message;
    }
}