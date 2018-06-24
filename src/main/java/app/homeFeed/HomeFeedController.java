package app.homeFeed;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/feed")
public class HomeFeedController {

    @GetMapping
    public ArrayList<HomeFeedModel> homefeedmodel () {
        ArrayList<HomeFeedModel> API = new ArrayList();
        API.add(new HomeFeedModel());
        return API;
    }
}