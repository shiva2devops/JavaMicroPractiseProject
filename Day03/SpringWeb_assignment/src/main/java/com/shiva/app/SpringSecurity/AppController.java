package com.shiva.app.SpringSecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


    @Value("${access.firstname}")
    String firstname;
    @RequestMapping("/request/hello")
    public String requestHello() {
        return "Hello from Request mapping"+firstname;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from say Hello:";
    }

    @PostMapping("/post")
    public String sayPost() {
        return "Hello from post:";
    }
}
