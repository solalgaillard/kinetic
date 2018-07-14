package qinetic.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;


import com.auth0.jwk.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwk.JwkException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import com.auth0.jwt.JWTVerifier;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


/*
 *
 * Decode Token
 *
 *
 * */

@Service
public class ParseAndVerifyJWT {

    private qinetic.configuration.Auth0Config auth0Config;

    @Autowired
    public void setAuth0Config(qinetic.configuration.Auth0Config auth0Config){
        this.auth0Config = auth0Config;
    }



    public String getSub(String aToken) {
        return JWT.decode(aToken).getSubject();
    }


    public String getKID(String aToken) {
        return JWT.decode(aToken).getKeyId();
    }



    public boolean verify(String aToken) {
        JwkProvider http = new UrlJwkProvider("https://kineticexpress.auth0.com/.wedsdsll-known/jwks.json");
        JwkProvider provider = new GuavaCachedJwkProvider(http);

        try {
            Jwk jwk = provider.get(this.getKID(aToken)); //throws Exception when not found or can't get one
            RSAPublicKey publicKey = (RSAPublicKey) jwk.getPublicKey();


            System.out.println(jwk);

            Algorithm algorithm = Algorithm.RSA256(publicKey, null);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("https://kineticexpress.auth0.com/")
                    .build(); //Reusable verifier instance
            System.out.println(this.getKID(aToken));
            DecodedJWT jwt = verifier.verify(aToken);
            return true;

        }
        catch (JwkException exception){
                return false;
        }

        catch (JWTVerificationException exception){
            return false;
        }

    }


}