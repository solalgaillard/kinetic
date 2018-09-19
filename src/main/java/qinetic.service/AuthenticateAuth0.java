package qinetic.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/*
*
* Get access token
* Store Refresh token with ip
* Spill it back
*
*
* */

@Service
public class AuthenticateAuth0 {

    private qinetic.configuration.Auth0Config auth0Config;

    @Autowired
    qinetic.model.Auth0Response restResponse;

    @Autowired
    public void setAuth0Config(qinetic.configuration.Auth0Config auth0Config){
        this.auth0Config = auth0Config;
    }


    public qinetic.model.Auth0Response getTokenFromCred(String email, String password) {

        RestTemplate restTemplate = new RestTemplate();

        String url = this.auth0Config.getISSUER() + "/oauth/token";

        String requestJson = "{" +
                "\"grant_type\": \"password\", " +
                "\"username\": \"" + email + "\", " +
                "\"password\": \"" + password +"\", " +
                "\"audience\": \"" + this.auth0Config.getAUDIENCE() + "\", "+
                "\"scope\": \"openid profile email offline_access\", "+
                "\"client_id\": \"" + this.auth0Config.getCLIENT_ID() + "\", "+
                "\"client_secret\": \"" + this.auth0Config.getCLIENT_SECRET() + "\""+
                "}";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

        restResponse = restTemplate
                .postForObject(url, entity, qinetic.model.Auth0Response.class);


        String restResponseTest = restTemplate
                .postForObject(url, entity, String.class);

        System.out.println(restResponseTest);


        return restResponse;
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



    public qinetic.model.Auth0Response getTokenFromSocial(String code) {

        RestTemplate restTemplate = new RestTemplate();

        String url = this.auth0Config.getISSUER() + "/oauth/token";
//Add Scope
        String requestJson = "{" +
                "\"grant_type\": \"authorization_code\", " +
                "\"client_id\": \"" + this.auth0Config.getCLIENT_ID() + "\", " +
                "\"client_secret\": \"" + this.auth0Config.getCLIENT_SECRET() + "\", " +
                "\"code\": \"" + code + "\", " +
                "\"redirect_uri\": \"https://localhost/social-login-redirect.html\"" +
                "}";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        restResponse = restTemplate
                .postForObject(url, entity, qinetic.model.Auth0Response.class);


        return restResponse;

    }
}