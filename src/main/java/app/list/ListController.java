package app.list;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListController {

    @GetMapping
    public ListModel listmodel() {
        return new ListModel();
    }
}