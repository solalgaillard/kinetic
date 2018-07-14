package qinetic.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("auth0")
public class Auth0Config {

    private String ISSUER, AUDIENCE, CLIENT_ID, CLIENT_SECRET;

    public String getISSUER() {
        return ISSUER;
    }

    public String getAUDIENCE() {
        return AUDIENCE;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public String getCLIENT_SECRET() {
        return CLIENT_SECRET;
    }




    public void setISSUER(String ISSUER) {
        this.ISSUER = ISSUER;
    }

    public void setAUDIENCE(String AUDIENCE) {
        this.AUDIENCE = AUDIENCE;
    }

    public void setCLIENT_ID(String CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public void setCLIENT_SECRET(String CLIENT_SECRET) {
        this.CLIENT_SECRET = CLIENT_SECRET;
    }
}