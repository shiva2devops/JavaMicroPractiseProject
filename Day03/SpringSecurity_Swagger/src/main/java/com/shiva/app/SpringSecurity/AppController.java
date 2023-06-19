package com.shiva.app.SpringSecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {


    @Value("${access.firstname}")
    String firstname;
    @RequestMapping(value="/request/hello", method= RequestMethod.GET)
    public String requestHello() {
        return "Hello from Request mapping"+firstname;
    }

    @RequestMapping(value="hello", method= RequestMethod.GET)
    public String sayHello() {
        return "Hello from say Hello:";
    }

    @RequestMapping(value="/request/hello", method= RequestMethod.POST)
    public String sayPost() {
        return "Hello from post:";
    }
}
