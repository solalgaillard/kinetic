package qinetic.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



public class SignUp {

    private final String firstName, lastName, email, password, DOB, phoneNumber;

    private final String USER_AGENT = "Qinetic/1.0", DOMAIN = "https://kineticexpress.auth0.com";

    public SignUp(String firstName, String lastName, String email, String password, String DOB, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
    }


    public ResponseEntity signUp() {

        RestTemplate restTemplate = new RestTemplate();


        String url = DOMAIN + "/dbconnections/signup";

        String requestJson = "{" +
                "\"client_id\": \"7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O\", " +
                "\"email\": \"" + email + "\", " +
                "\"password\": \"" + password +"\", " +
                "\"connection\": \"Username-Password-Authentication\", " +
                "\"user_metadata\":{\"" +
                    "firstName\":\"" + firstName + "\"," +
                    "\"lastName\":\"" + lastName  + "\"," +
                    "\"DOB\":\"" + DOB  + "\"," +
                    "\"phoneNumber\":\"" + phoneNumber  +
                    "\"} " +
                "}";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

        ResponseEntity restResponse = restTemplate
                .exchange(url, HttpMethod.POST, entity, String.class);

        return restResponse;

    }

}
