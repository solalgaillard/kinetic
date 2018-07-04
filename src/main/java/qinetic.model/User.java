package qinetic.model;

import java.util.*;

public class User {

    private final String userUUID;
    private final String userToken;
    private final String userName;
    private final String userPicture;
    private final ArrayList<ListInfo> lists;
    private final ArrayList<UserRelation> following;
    private final ArrayList<UserRelation> followers;
    private final ArrayList<UserRelation> blocked;
    private final Settings settings;
    private final int InboxCount;


    public User(String userUUID, String userToken){
        this.userUUID = userUUID;
        this.userToken = userToken;
        userName = "Solal Gaillard";
        userPicture = "string/string.jpg";

        lists = new ArrayList();
        lists.add(new ListInfo());

        following = new ArrayList();
        following.add(new UserRelation());

        followers = new ArrayList();
        followers.add(new UserRelation());

        blocked = new ArrayList();
        blocked.add(new UserRelation());



        settings = new Settings();

        InboxCount = 32;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getUserToken() {
        return userToken;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public ArrayList<ListInfo> getLists() {
        return lists;
    }

    public ArrayList<UserRelation> getFollowing() {
        return following;
    }
    public ArrayList<UserRelation> getFollowers() {
        return followers;
    }
    public ArrayList<UserRelation> getBlocked() {
        return blocked;
    }

    public Settings getSettings() {
        return settings;
    }

    public int getInboxCount() {
        return InboxCount;
    }
}

class ListInfo {

    private String listUUID;
    private String listName;
    private String listDescription;
    private String listRelation;

    private ListSettings listSettings;


    public ListInfo() {
        listUUID = "truc";
        listName = "Vienna 1910";
        listDescription = "BlahBlahBlah";
        listRelation = "admin";

        listSettings = new ListSettings();
    }

    public String getListUUID() {
        return listUUID;
    }

    public String getListName() {
        return listName;
    }

    public String getListDescription() {
        return listDescription;
    }

    public String getListRelation() {
        return listRelation;
    }

    public ListSettings getListSettings() {
        return listSettings;
    }
}

class ListSettings  {

    private ArrayList<UserRelation> invitedAsAdmin;
    private ArrayList<UserRelation> invitedToFollow;

    private String listViewableBy;
    private String feedViewableBy;

    public ListSettings() {
        invitedAsAdmin = new ArrayList();
        invitedAsAdmin.add(new UserRelation());

        invitedToFollow = new ArrayList();
        invitedToFollow.add(new UserRelation());

        listViewableBy = "all";
        feedViewableBy = "all";
    }

    public ArrayList<UserRelation> getInvitedAsAdmin() {
        return invitedAsAdmin;
    }

    public ArrayList<UserRelation> getInvitedToFollow() {
        return invitedToFollow;
    }

    public String getListViewableBy() {
        return listViewableBy;
    }

    public String getFeedViewableBy() {
        return feedViewableBy;
    }

}

class UserRelation {

    private String userUUID;
    private String userName;

    public UserRelation() {
        userUUID = "truc";
        userName = "bidule";
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getUserName() {
        return userName;
    }
}

class Settings {

    private String userPicture;
    private int[] pictureAlignment;

    public Settings() {
        userPicture = "maching";
        pictureAlignment = new int[]{0,1,2};
    }

    public String getUserPicture() {
        return userPicture;
    }

    public int[] getPictureAlignment() {
        return pictureAlignment;
    }
}