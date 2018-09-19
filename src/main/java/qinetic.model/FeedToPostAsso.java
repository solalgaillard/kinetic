package qinetic.model;

        import java.io.*;
        import java.util.Objects;
        import javax.persistence.Embeddable;
        import javax.persistence.EmbeddedId;
        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.Table;

        import java.util.ArrayList;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */



@Embeddable
public class FeedToPostAsso implements Serializable {

    @Column(name = "feed_UUID", length = 36)
    private String feedUUID;

    @Column(name = "post_UUID", length = 36)
    private String postUUID;

    public FeedToPostAsso() {

    }

    public FeedToPostAsso(String feedUUID, String postUUID) {
        this.feedUUID = feedUUID;
        this.postUUID = postUUID;
    }

    public String getFeedUUID() {
        return feedUUID;
    }

    public String getPostUUID() {
        return postUUID;
    }

    public void setFeedUUID(String feedUUID) {
        this.feedUUID = feedUUID;
    }

    public void setPostUUID(String postUUID) {
        this.postUUID = postUUID;
    }

    @Override
    public String toString() {
        return "peu importe";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeedUUID(), getPostUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeedToPostAsso)) return false;
        FeedToPostAsso that = (FeedToPostAsso) o;
        return Objects.equals(getFeedUUID(), that.getFeedUUID()) &&
                Objects.equals(getPostUUID(), that.getPostUUID());

    }
}