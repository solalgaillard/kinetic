package qinetic.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Authenticate {

    private final String USER_AGENT = "Qinetic/1.0", DOMAIN = "https://kineticexpress.auth0.com",
    email, password;

    public Authenticate(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public qinetic.model.User connect() {

        RestTemplate restTemplate = new RestTemplate();

        String url = DOMAIN + "/oauth/token";

        String requestJson = "{\"" +
                "grant_type\": \"password\", " +
                "\"username\": \"" + email + "\", " +
                "\"password\": \"" + password +"\", " +
                "\"client_id\": \"7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O\", " +
                "\"client_secret\": \"A9_2PNqixCjxJ7hlGIJn8licpeiOX0-UTRiHcV7LNuCq3dPtHhYN9-_yQJ670Afc\" " +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);


        Auth0Response restResponse = restTemplate
                .postForObject(url, entity, Auth0Response.class);


        String token = restResponse.getIdToken();

        try {
            DecodedJWT jwt = JWT.decode(token);
            String subject = jwt.getSubject();
            Pattern pattern = Pattern.compile("^auth0[|](.*?)$");
            Matcher matcher = pattern.matcher(subject);
            if (matcher.matches())
            {
                return new qinetic.model.User(matcher.group(1), restResponse.getAccessToken());

            }
        } catch (JWTDecodeException exception){
            //Invalid token
        }

        return new qinetic.model.User("","");

    }

}

class Auth0Response {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("id_token")
    private String idToken;
    private String scope;
    private String tokenType;
    private long expiresIn;

    public Auth0Response(){
    }

    public String getIdToken() {
        return idToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}