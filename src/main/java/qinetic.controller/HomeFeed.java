package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

import qinetic.service.JWTToId;


@RestController
@RequestMapping("/feed")
public class HomeFeed {

    @GetMapping
    public ArrayList<qinetic.model.HomeFeed> homeFeed(@RequestHeader("Authorization") String accessToken) {
        ArrayList<qinetic.model.HomeFeed> API = new ArrayList();
        JWTToId JWTConverter = new JWTToId();
        API.add(new qinetic.model.HomeFeed(JWTConverter.convertToId(accessToken)));
        return API;
    }
}