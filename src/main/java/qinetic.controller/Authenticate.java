package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.*;



@RestController
public class Authenticate {

    @Autowired
    qinetic.service.AuthenticateAuth0 authenticateProcessing;
    @Autowired
    qinetic.model.Auth0Response responseAuth0;
    @Autowired
    qinetic.service.ParseAndVerifyJWT parseToken;
    @Autowired
    qinetic.repository.RefreshTokensDAO refreshTokensDAO;

    private qinetic.model.User getUserInfo(String id, String token) {
        return new qinetic.model.User(id, token);
    }


    @RequestMapping(method=RequestMethod.POST, value="/authenticate", headers="Connection-Type=Password")
    public @ResponseBody qinetic.model.User userInfo(@RequestBody AuthJSONToObj credentials) {

        responseAuth0 = authenticateProcessing.getTokenFromCred(credentials.getUsername(),credentials.getPassword());

        qinetic.model.RefreshTokens refreshTokens = new qinetic.model.RefreshTokens();

        String token = responseAuth0.getAccessToken();

        refreshTokens.setAccessToken(token);

        refreshTokens.setRefreshToken(responseAuth0.getRefreshToken());


        refreshTokensDAO.save(refreshTokens);

        return getUserInfo(parseToken.getSub(token),token);

    }

    @RequestMapping(method=RequestMethod.POST, value="/authenticate", headers="Connection-Type=Social")
    public @ResponseBody qinetic.model.User userInfo(@RequestBody Code socialCred) {

        responseAuth0 = authenticateProcessing.getTokenFromSocial(socialCred.getCode());

        String token = responseAuth0.getAccessToken();

        return getUserInfo(parseToken.getSub(token),token);

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


class Code {
    private String code;

    public Code() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
