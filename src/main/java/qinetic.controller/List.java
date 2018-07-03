package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/list")
public class List {

    @GetMapping
    public qinetic.model.List listmodel() {
        return new qinetic.model.List();
    }
}