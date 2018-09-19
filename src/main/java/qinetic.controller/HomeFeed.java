package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.HashMap;
import qinetic.service.JWTToId;
import java.util.UUID;
import java.time.Instant;
import org.springframework.beans.factory.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/feed")
public class HomeFeed {

    @Autowired
    qinetic.repository.PostToFeedDAO postToFeedDAO;


    @Autowired
    qinetic.repository.FeedToPostAssoDAO feedToPostAssoDAO;

    @GetMapping
    public ArrayList<qinetic.model.HomeFeed> homeFeedGet(@RequestHeader("Authorization") String accessToken) {
        ArrayList<qinetic.model.HomeFeed> API = new ArrayList();
        JWTToId JWTConverter = new JWTToId(accessToken);
        API.add(new qinetic.model.HomeFeed(JWTConverter.getUser()));
        return API;


    }

    @PostMapping
    public Optional<qinetic.model.PostToFeed> feedPost(
            @RequestBody ArrayList<Object> message,
            @RequestHeader("Authorization") String accessToken) {


        JWTToId JWTConverter = new JWTToId(accessToken);

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        Instant instant = Instant.now();


        qinetic.model.PostToFeed postToFeed = new qinetic.model.PostToFeed();

        qinetic.model.FeedToPostAsso feedToPostAsso = new qinetic.model.FeedToPostAsso();

        qinetic.model.FeedToPostAssoComposite feedToPostAssoComposite = new qinetic.model.FeedToPostAssoComposite();


        postToFeed.setPostUUID(randomUUIDString);

        postToFeed.setUserUUID(JWTConverter.getUser());

        postToFeed.setTimestamp(instant.toEpochMilli());

        postToFeed.setMessage(message);

        feedToPostAsso.setFeedUUID("peu importe");

        feedToPostAsso.setPostUUID(randomUUIDString);


        postToFeedDAO.save(postToFeed);

        feedToPostAssoComposite.setFeedsAndPostsIds(feedToPostAsso);


        feedToPostAssoDAO.save(feedToPostAssoComposite);

        Optional<qinetic.model.FeedToPostAssoComposite> val = feedToPostAssoDAO.findById(feedToPostAsso);

        qinetic.model.FeedToPostAsso val2 = val.get().getFeedsAndPostsIds();

        Optional<qinetic.model.PostToFeed> val3 = postToFeedDAO.findById(val2.getPostUUID());

        return val3;
    }

}