package app.homeFeed;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;



public class Authenticate {

    private final String USER_AGENT = "Qinetic/1.0", DOMAIN = "https://kineticexpress.auth0.com";

    private String response;

    public Authenticate(String email, String password) {
        this.response = connect(email, password);
    }


    public String connect(String email, String password) {

        RestTemplate restTemplate = new RestTemplate();

        String url = DOMAIN + "/oauth/ro";
        String requestJson = "{\"" +
                "grant_type\": \"password\", " +
                "\"username\": " + email + ", " +
                "\"password\": " + password +", " +
                "\"audience\": \"https://localhost\", "+
                "\"client_id\": \"7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O\", " +
                "\"client_secret\": \"A9_2PNqixCjxJ7hlGIJn8licpeiOX0-UTRiHcV7LNuCq3dPtHhYN9-_yQJ670Afc\", " +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        System.out.println(answer);
        return answer;

    }

}
