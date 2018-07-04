package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/authenticate")
public class Authenticate {

    @PostMapping
    public qinetic.model.User userInfo(@RequestBody AuthJSONToObj credentials) {
        return new qinetic.service.Authenticate(credentials.getUsername(),credentials.getPassword()).connect();
    }
}



class AuthJSONToObj {
    private final String username, password;

    public AuthJSONToObj(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
