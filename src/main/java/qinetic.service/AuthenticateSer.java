package qinetic.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;

/*
*
* Get access token
* Store Refresh token with ip
* Spill it back
*
*
* */

@Service
public class AuthenticateSer {

    private qinetic.configuration.Auth0Config auth0Config;


    @Autowired
    public void setAuth0Config(qinetic.configuration.Auth0Config auth0Config){
        this.auth0Config = auth0Config;
    }


    public String getTokenFromCred(String email, String password) {

        RestTemplate restTemplate = new RestTemplate();

        String url = this.auth0Config.getISSUER() + "/oauth/token";

        System.out.println(url);

        String requestJson = "{\"" +
                "grant_type\": \"password\", " +
                "\"username\": \"" + email + "\", " +
                "\"password\": \"" + password +"\", " +
                "\"audience\": \"" + this.auth0Config.getAUDIENCE() + "\", "+
                "\"client_id\": \"" + this.auth0Config.getCLIENT_ID() + "\", "+
                "\"client_secret\": \"" + this.auth0Config.getCLIENT_SECRET() + "\" "+
                "}";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

        Auth0Response restResponse = restTemplate
                .postForObject(url, entity, Auth0Response.class);


        return restResponse.getAccessToken();
/*
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

   */}

}

class Auth0Response {

    @JsonProperty("access_token")
    private String accessToken;


    public Auth0Response(){
    }

    public String getAccessToken() {
        return accessToken;
    }
}