package app.homeFeed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {


    @PostMapping
    public Authenticate toAuth0(@RequestBody UserCredentials userCred) {
        return new Authenticate(userCred.getUsername(),userCred.getPassword());
    }
}