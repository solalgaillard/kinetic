package app.user;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

/*
* Peut utiliser un token ou bien les identifiants pour accéder à la route
*
*
*
* */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public UserModel usermodel () {
        return new UserModel();
    }
}