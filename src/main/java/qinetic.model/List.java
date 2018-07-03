package qinetic.model;

import java.util.ArrayList;

public class List {

    private final ArrayList<Feed> feed;

    public List() {
        feed = new ArrayList();
        Feed aFeed = new Feed();
        feed.add(aFeed);
    }

    public ArrayList<Feed> getFeed() {
        return feed;
    }

}

class Feed {

    private final String postUUID;
    private final String userUUID;
    private final String userName;
    private final String userPicture;
    private final String timestamp;

    private final ArrayList<Message> message;


    public Feed(){
        postUUID = "truc";
        userUUID = "truc";
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

    public String getTimestamp() {
        return timestamp;
    }

    public ArrayList<Message> getMessage() {
        return message;
    }
}

