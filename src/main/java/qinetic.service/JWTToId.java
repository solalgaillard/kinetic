package qinetic.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTToId {

    private final String USER_AGENT = "Qinetic/1.0", DOMAIN = "https://kineticexpress.auth0.com";

    public JWTToId() {
    }


    public String convertToId(String JWT) {

        RestTemplate restTemplate = new RestTemplate();

        String url = DOMAIN + "/userinfo";



        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", JWT);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<TokToIdResponse> restResponse = restTemplate
                .exchange(url, HttpMethod.GET, entity, TokToIdResponse.class);



        return restResponse.getBody().getUserId();

    }

}

class TokToIdResponse {

    @JsonProperty("sub")
    private String userId;

    public TokToIdResponse(){
    }

    public String getUserId() {
        System.out.println(this.userId);
        return userId;
    }
}