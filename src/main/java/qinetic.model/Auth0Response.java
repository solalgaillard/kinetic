package qinetic.model;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Component
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Auth0Response {
    private String accessToken;
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
}