package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

/*
* Peut utiliser un token ou bien les identifiants pour accéder à la route
*
*
*
* */

@RestController
@RequestMapping("/user")
public class User {

    @GetMapping
    public qinetic.model.User usermodel () {
        return new qinetic.model.User("","");
    }
}