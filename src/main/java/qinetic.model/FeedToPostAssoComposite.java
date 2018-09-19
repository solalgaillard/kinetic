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




@Entity
@Table(name = "feedtopostsasso")
public class FeedToPostAssoComposite implements Serializable {

    @EmbeddedId
    private FeedToPostAsso feedsAndPostsIds;

    public FeedToPostAsso getFeedsAndPostsIds() {
        return feedsAndPostsIds;
    }

    public void setFeedsAndPostsIds(FeedToPostAsso feedsAndPostsIds) {
        this.feedsAndPostsIds = feedsAndPostsIds;
    }
}

