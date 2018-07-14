package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.*;



@RestController
public class Authenticate {

    @Autowired
    qinetic.service.AuthenticateSer authenticateProcessing;

    @Autowired
    qinetic.service.ParseAndVerifyJWT verifyToken;


    @RequestMapping(method=RequestMethod.POST, value="/authenticate", headers="Connection-Type=Password")
    public @ResponseBody ResponseEntity<String> userInfo(@RequestBody AuthJSONToObj credentials) {

        String token = authenticateProcessing.getTokenFromCred(credentials.getUsername(),credentials.getPassword());


       boolean isTokenValid = verifyToken.verify(token);

       System.out.println(isTokenValid);



        //qinetic.model.User(toke);

        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>(token, responseHeaders, HttpStatus.OK);
    }
/*
    @RequestMapping(method=RequestMethod.POST, value="/authenticate", headers="Return-Type=FooExtra")
    public @ResponseBody qinetic.model.User UserInfoExtra(@RequestBody Code code) {
        return new qinetic.service.Authenticate("test.account@signup.com","Solgai#06").connect();
    }
*/

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


class Code {
    private final String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
