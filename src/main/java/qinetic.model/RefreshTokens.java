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

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */


@Entity
@Table(name = "refreshtokens")
public class RefreshTokens implements Serializable {
    @Id
    @Column(name = "access_token", length = 1024)
    private String accessToken;

    @Column(name = "refresh_token", length = 1024)
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    @Override
    public String toString() {
        return "RefreshTokens [accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccessToken());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RefreshTokens other = (RefreshTokens) obj;
        if (accessToken != other.accessToken)
            return false;
        return true;
    }

}


