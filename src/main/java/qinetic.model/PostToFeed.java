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
@Table(name = "posts")
public class PostToFeed implements Serializable {
    @Id
    @Column(name = "post_UUID", length = 36)
    private String postUUID;

    @Column(name = "user_UUID", length = 36)
    private String userUUID;

    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "message", length = 2000)
    private ArrayList<Object> message;

    public String getPostUUID() {
        return postUUID;
    }
    public void setPostUUID(String postUUID) {
        this.postUUID = postUUID;
    }


    public String getUserUUID() {
        return userUUID;
    }
    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }


    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Object> getMessage() {
        return message;
    }
    public void setMessage(ArrayList<Object> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "peu importe";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostUUID());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostToFeed other = (PostToFeed) obj;
        if (postUUID != other.getPostUUID())
            return false;
        return true;
    }

}


