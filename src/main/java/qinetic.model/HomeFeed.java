package qinetic.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeFeed {

    private final String postUUID;
    private final String userUUID;
    private final String userName;
    private final String userPicture;
    private final String timestamp;

    private final ArrayList<Object> message;

    //Ici, il faut prendre le user id et regarder pour récupérer le feedID


    public HomeFeed(String userID){
        postUUID = "truc";
        userUUID = userID;
        userName = "Solal Gaillard";
        userPicture = "https://twistedsifter.files.wordpress.com/2012/09/trippy-profile-pic-portrait-head-on-and-from-side-angle.jpg?w=800&h=700";
        timestamp = "10101874";
        message = new ArrayList();
        //ArrayList<Object> subMessage = new ArrayList();
        HashMap<String, String> tmp = new HashMap<String, String>();
        tmp.put("text", "Blah");
        message.add("texttest");
        message.add(tmp);
        //message.add(subMessage);
        //message.add(subMessage);
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
    public ArrayList<Object> getMessage() {
        return message;
    }
}