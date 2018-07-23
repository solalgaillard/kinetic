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



@Embeddable
public class IpTokAsso implements Serializable {

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "ip")
    private String ip;

    public IpTokAsso(String accessToken, String ip) {
        this.accessToken = accessToken;
        this.ip = ip;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getIp() {
        return ip;
    }


    @Override
    public String toString() {
        return "RefreshTokens [access_token=" + accessToken + ", ip=" + ip + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccessToken() + getIp());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IpTokAsso other = (IpTokAsso) obj;
        if (accessToken != other.accessToken && ip != other.ip)
            return false;
        return true;
    }

}

@Entity
@Table(name = "iptokasso")
class IpTokAssoEnt implements Serializable {
    @EmbeddedId
    private IpTokAsso tokensAndIps;

    public IpTokAsso getTokensAndIps() {
        return tokensAndIps;
    }



}

